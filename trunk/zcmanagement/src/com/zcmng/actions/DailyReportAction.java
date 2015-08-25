package com.zcmng.actions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zcmng.commons.Constants;
import com.zcmng.commons.ValidationUtil;
import com.zcmng.forms.CustomerForm;
import com.zcmng.forms.CustomerMapper;
import com.zcmng.forms.DailyReportForm;
import com.zcmng.forms.DailyReportMapper;
import com.zcmng.forms.PaginationForm;
import com.zcmng.models.Contact;
import com.zcmng.models.Customer;
import com.zcmng.models.DailyReport;
import com.zcmng.services.CustomerService;
import com.zcmng.services.DailyReportService;

/**
 * @author sunk
 *
 */
@SuppressWarnings("serial")
public class DailyReportAction extends ActionSupport implements ModelDriven<DailyReportForm>
{
	private DailyReportForm dailyReportForm = new DailyReportForm();
	private DailyReportService dailyReportService;
	private CustomerService customerService;
	
	public String unspecified() throws Exception
	{
		Map<String, Object> params = ActionContext.getContext().getParameters();
		PaginationForm pagiForm = new PaginationForm();
		if(params.get("currentPage") != null)
		{
			String currentPage = ((String[])params.get("currentPage"))[0];
			if(currentPage!= null && !Constants.EMPTY_STRING.equals(currentPage) && !Constants.UNDEFINE_STRING.equals(currentPage) )
			{
				pagiForm.setCurrentPage(Integer.parseInt(currentPage));
			}
		}
		Map<String, Object> pagiMap = new HashMap<String, Object>();
		pagiMap.put("pageStart", pagiForm.getPageStart());
		pagiMap.put("pageEnd", pagiForm.getPageEnd());
		
		ActionContext ctx = ActionContext.getContext();
		Contact user = (Contact)ctx.getSession().get("currentUser");
		if(!"admin".equals(user.getLoginId()))
		{
			pagiMap.put("userId", user.getId());
		}
		
		List<DailyReport> dailyReportList = dailyReportService.findAllDailyReports(pagiMap);
		List<DailyReportForm> formList = new ArrayList<DailyReportForm>();
		DailyReportMapper mapper = new DailyReportMapper();
		for(DailyReport dailyReport : dailyReportList)
		{
			DailyReportForm form = new DailyReportForm();
			mapper.toDailyReportForm(dailyReport, form);
			formList.add(form);
		}
		
		ctx.put("dailyReportList", formList);
		
		pagiForm.setTotalCount(dailyReportService.getDailyReportsCountByCondition());
		ctx.put("pagiForm", pagiForm);
		return SUCCESS;
	}
	
	public String forwardUpdateDailyReport() throws Exception
	{
		Map<String, Object> params = ActionContext.getContext().getParameters();

		getCustomerList();		
		
		if(params.get("dailyReportId") != null)
		{
			String dailyReportId = ((String[])params.get("dailyReportId"))[0];
			if(dailyReportId!= null && !Constants.EMPTY_STRING.equals(dailyReportId) && !Constants.UNDEFINE_STRING.equals(dailyReportId) )
			{
				DailyReport dailyReport = dailyReportService.findDailyReportById(Integer.parseInt(dailyReportId));
				
				DailyReportMapper drMapper = new DailyReportMapper();
				drMapper.toDailyReportForm(dailyReport, dailyReportForm);
			}			
		}
		
		return INPUT;
	}
	
	public String updateDailyReport() throws Exception
	{
		DailyReportMapper mapper = new DailyReportMapper();
		DailyReport dailyReport = new DailyReport(); 
		mapper.toDailyReportModel(dailyReportForm, dailyReport);
		
		ActionContext ctx = ActionContext.getContext();
		Contact user = (Contact)ctx.getSession().get("currentUser");
		dailyReport.setUser(user);
		
		dailyReportService.insertOrUpdateDailyReport(dailyReport);
		
		return SUCCESS;
	}
	
	public String deleteDailyReport() throws Exception
	{
		Map<String, Object> params = ActionContext.getContext().getParameters();
		String dailyReportIds = ((String[])params.get("deldailyReportIds"))[0];
		
		dailyReportService.deleteDailyReports(dailyReportIds);
		
		return SUCCESS;
	}		

	/**
	 * Validation when insert/update an User
	 * 
	 * @throws Exception
	 */
	public void validateUpdateDailyReport() throws Exception
	{
	    validateCustomerId();	
	    validateTask();
	    validateDate();
	    
	    getCustomerList();
	}	
	
	private void validateCustomerId()
	{
		Integer companyId = dailyReportForm.getCustomerId();
		if (companyId == 0)
		{
			this.addFieldError("companyId", this.getText("zongcheng.error.required",
					new String[] { this.getText("zongcheng.label.companyName") }));
		}		
	}	
	
	private void validateTask()
	{
		String task = dailyReportForm.getTask();
		if (!ValidationUtil.validateRequired(task))
		{
			this.addFieldError("task", this.getText("zongcheng.error.required",
					new String[] { this.getText("zongcheng.label.task") }));
		}		
	}
	
	private void validateDate() throws Exception
	{
		String publishDate = dailyReportForm.getPublishDate();
		
		if (!ValidationUtil.validateRequired(publishDate))
		{
			this.addFieldError("publishDate", this.getText("zongcheng.error.required",
					new String[] { this.getText("zongcheng.label.publishDate") }));
			return;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(Constants.DATE_FORMAT_YMD);
		Date pubDate = sdf.parse(publishDate);
		Date currentDate = new Date();	
		
		if (pubDate.before(currentDate))
		{
			this.addFieldError("publishDate", this.getText("zongcheng.error.dateBefore",
					new String[] { this.getText("zongcheng.label.publishDate") }));	
		}		
	}

	private void getCustomerList() throws Exception 
	{
		List<Customer> customerList = customerService.findAllCustomers();
		CustomerMapper cuMapper = new CustomerMapper();
		List<CustomerForm> customerFormList = new ArrayList<CustomerForm>();
		for(Customer cus : customerList)
		{
			CustomerForm customerForm = new CustomerForm();
			cuMapper.toCustomerForm(cus, customerForm);
			customerFormList.add(customerForm);
		}
		ActionContext ctx = ActionContext.getContext();
		ctx.put("customerList", customerFormList);
	}	
	
	public DailyReportForm getModel()
	{
		return dailyReportForm;
	}
	
	public void setDailyReportService(DailyReportService dailyReportService)
	{
		this.dailyReportService = dailyReportService;
	}
	
	public void setCustomerService(CustomerService customerService)
	{
		this.customerService = customerService;
	}	
}
