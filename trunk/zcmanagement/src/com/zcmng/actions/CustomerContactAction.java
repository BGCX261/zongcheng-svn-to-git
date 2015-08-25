package com.zcmng.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zcmng.commons.Constants;
import com.zcmng.forms.CustomerContactForm;
import com.zcmng.forms.CustomerContactMapper;
import com.zcmng.models.CustomerContact;
import com.zcmng.services.CustomerService;

/**
 * @author sunk
 *
 */
@SuppressWarnings("serial")
public class CustomerContactAction extends ActionSupport implements ModelDriven<CustomerContactForm>
{
	private CustomerContactForm form = new CustomerContactForm();
	private CustomerService customerService;

	public String unspecified() throws Exception
	{
		Map<String, Object> params = ActionContext.getContext().getParameters();
		String customerId = ((String[])params.get("customerId"))[0];
	
		List<CustomerContact> customerContactList = customerService.findCustomerContactsByCustomerId(Integer.parseInt(customerId));
		List<CustomerContactForm> formList = new ArrayList<CustomerContactForm>();
		CustomerContactMapper mapper = new CustomerContactMapper();
		for(CustomerContact customerContact : customerContactList)
		{
			CustomerContactForm form = new CustomerContactForm();
			mapper.toCustomerContactForm(customerContact, form);
			formList.add(form);
		}
		
		ActionContext ctx = ActionContext.getContext();
		ctx.put("customerContactList", formList);	
		ctx.put("customerId", customerId);	
		return SUCCESS;
	}
	
	public String forwardUpdateCustomerContact() throws Exception
	{
		Map<String, Object> params = ActionContext.getContext().getParameters();
		if(params.get("customerContactId") != null)
		{
			String customerContactId = ((String[])params.get("customerContactId"))[0];
			if(customerContactId!= null && !Constants.EMPTY_STRING.equals(customerContactId) && !Constants.UNDEFINE_STRING.equals(customerContactId) )
			{
				CustomerContact customerContact = customerService.findCustomerContactById(Integer.parseInt(customerContactId));
				
				CustomerContactMapper mapper = new CustomerContactMapper();
				mapper.toCustomerContactForm(customerContact, form);
			}			
		}
		else
		{
			String customerId = ((String[])params.get("customerId"))[0];
			form.setCustomerId(Integer.parseInt(customerId));			
		}
		
		return INPUT;
	}
	
	public String updateCustomerContact() throws Exception
	{
		CustomerContactMapper mapper = new CustomerContactMapper();
		CustomerContact customerContact = new CustomerContact(); 
		mapper.toCustomerContactModel(form, customerContact);
		
		customerService.insertOrUpdateCustomerContact(customerContact);
		
		return SUCCESS;
	}
	
	public String deleteCustomerContact() throws Exception
	{
		Map<String, Object> params = ActionContext.getContext().getParameters();
		String customerContactIds = ((String[])params.get("delCustomerContactIds"))[0];
		
		customerService.deleteCustomerContacts(customerContactIds);
		
		return SUCCESS;
	}		
	
	public void setCustomerService(CustomerService customerService)
	{
		this.customerService = customerService;
	}

	public CustomerContactForm getModel()
	{
		return form;
	}	
}
