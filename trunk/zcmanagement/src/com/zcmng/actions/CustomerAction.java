package com.zcmng.actions;

import java.util.ArrayList;
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
import com.zcmng.forms.PaginationForm;
import com.zcmng.models.Contact;
import com.zcmng.models.Customer;
import com.zcmng.services.CustomerService;

/**
 * @author sunk
 *
 */
@SuppressWarnings("serial")
public class CustomerAction extends ActionSupport implements ModelDriven<CustomerForm>
{
	private CustomerForm form = new CustomerForm();
	private CustomerService customerService;

	public String unspecified() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> params = ctx.getParameters();
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
		
		Contact owner = (Contact)ctx.getSession().get("currentUser");
		if(owner.getId() != 1)
		{
			pagiMap.put("owner", ctx.getSession().get("currentUser"));	
		}		
		
		List<Customer> customerList = customerService.findCustomersForPagination(pagiMap);
		List<CustomerForm> formList = new ArrayList<CustomerForm>();
		CustomerMapper mapper = new CustomerMapper();
		for(Customer customer : customerList)
		{
			CustomerForm form = new CustomerForm();
			mapper.toCustomerForm(customer, form);
			formList.add(form);
		}		
		ctx.put("customerList", formList);
		
		pagiForm.setTotalCount(customerService.getCustomersCountByCondition(pagiMap));
		ctx.put("pagiForm", pagiForm);		
		return SUCCESS;
	}
	
	public String forwardUpdateCustomer() throws Exception
	{
		Map<String, Object> params = ActionContext.getContext().getParameters();
		if(params.get("customerId") != null)
		{
			String customerId = ((String[])params.get("customerId"))[0];
			if(customerId!= null && !Constants.EMPTY_STRING.equals(customerId) && !Constants.UNDEFINE_STRING.equals(customerId) )
			{
				Customer customer = customerService.findCustomerById(Integer.parseInt(customerId));
				
				CustomerMapper mapper = new CustomerMapper();
				mapper.toCustomerForm(customer, form);
			}			
		}
		
		return INPUT;
	}
	
	public String updateCustomer() throws Exception
	{
		CustomerMapper mapper = new CustomerMapper();
		Customer customer = new Customer(); 
		mapper.toCustomerModel(form, customer);
		
		ActionContext ctx = ActionContext.getContext();
		customer.setOwner(((Contact)ctx.getSession().get("currentUser")));
		customerService.insertOrUpdateCustomer(customer);
		
		return SUCCESS;
	}
	
	public String deleteCustomer() throws Exception
	{
		Map<String, Object> params = ActionContext.getContext().getParameters();
		String customerIds = ((String[])params.get("delCustomerIds"))[0];
		
		customerService.deleteCustomers(customerIds);
		
		return SUCCESS;
	}		

	/**
	 * Validation when insert/update an User
	 * 
	 * @throws Exception
	 */
	public void validateUpdateCustomer() throws Exception
	{
		validateCompanyName();	
	}	
	
	private void validateCompanyName()
	{
		String companyName = form.getCompanyName();
		if (!ValidationUtil.validateRequired(companyName))
		{
			this.addFieldError("companyName", this.getText("zongcheng.error.required",
					new String[] { this.getText("zongcheng.label.companyName") }));
		} 
		else if (!ValidationUtil.validateMaxLength( companyName,Constants.MAX_DB_STRING_64))
		{
			this.addFieldError("companyName", this.getText("zongcheng.error.maxlength",
					new String[] { this.getText("zongcheng.label.companyName"), Constants.MAX_DB_STRING_64+"" }));			
		}			
	}		
	
	public void setCustomerService(CustomerService customerService)
	{
		this.customerService = customerService;
	}

	public CustomerForm getModel()
	{
		return form;
	}	
}
