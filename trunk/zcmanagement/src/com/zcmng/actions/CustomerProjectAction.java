package com.zcmng.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zcmng.commons.Constants;
import com.zcmng.forms.CustomerProjectForm;
import com.zcmng.forms.CustomerProjectMapper;
import com.zcmng.models.CustomerProject;
import com.zcmng.services.CustomerService;

/**
 * @author sunk
 *
 */
@SuppressWarnings("serial")
public class CustomerProjectAction extends ActionSupport implements ModelDriven<CustomerProjectForm>
{
	private CustomerProjectForm form = new CustomerProjectForm();
	private CustomerService customerService;

	public String unspecified() throws Exception
	{
		Map<String, Object> params = ActionContext.getContext().getParameters();
		String customerId = ((String[])params.get("customerId"))[0];
	
		List<CustomerProject> customerProjectList = customerService.findCustomerProjectsByCustomerId(Integer.parseInt(customerId));
		List<CustomerProjectForm> formList = new ArrayList<CustomerProjectForm>();
		CustomerProjectMapper mapper = new CustomerProjectMapper();
		for(CustomerProject customerProject : customerProjectList)
		{
			CustomerProjectForm form = new CustomerProjectForm();
			mapper.toCustomerProjectForm(customerProject, form);
			formList.add(form);
		}
		
		ActionContext ctx = ActionContext.getContext();
		ctx.put("customerProjectList", formList);	
		return SUCCESS;
	}
	
	public String forwardUpdateCustomerProject() throws Exception
	{
		Map<String, Object> params = ActionContext.getContext().getParameters();
		if(params.get("customerProjectId") != null)
		{
			String customerProjectId = ((String[])params.get("customerProjectId"))[0];
			if(customerProjectId!= null && !Constants.EMPTY_STRING.equals(customerProjectId) && !Constants.UNDEFINE_STRING.equals(customerProjectId) )
			{
				CustomerProject customerProject = customerService.findCustomerProjectById(Integer.parseInt(customerProjectId));
				
				CustomerProjectMapper mapper = new CustomerProjectMapper();
				mapper.toCustomerProjectForm(customerProject, form);
			}			
		}
		else
		{
			String customerId = ((String[])params.get("customerId"))[0];
			form.setCustomerId(Integer.parseInt(customerId));			
		}
		
		return INPUT;
	}
	
	public String updateCustomerProject() throws Exception
	{
		CustomerProjectMapper mapper = new CustomerProjectMapper();
		CustomerProject customerProject = new CustomerProject(); 
		mapper.toCustomerProjectModel(form, customerProject);
		
		customerService.insertOrUpdateCustomerProject(customerProject);
		
		return SUCCESS;
	}
	
	public String deleteCustomerProject() throws Exception
	{
		Map<String, Object> params = ActionContext.getContext().getParameters();
		String customerProjectIds = ((String[])params.get("delCustomerProjectIds"))[0];
		
		customerService.deleteCustomerProjects(customerProjectIds);
		
		return SUCCESS;
	}		
	
	public void setCustomerService(CustomerService customerService)
	{
		this.customerService = customerService;
	}

	public CustomerProjectForm getModel()
	{
		return form;
	}	
}
