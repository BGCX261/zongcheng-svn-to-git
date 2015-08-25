package com.zcmng.forms;

import com.zcmng.models.CustomerContact;

/**
 * @author sunk
 *
 */
public class CustomerContactMapper
{
	public void toCustomerContactForm(CustomerContact customerContact, CustomerContactForm form)
	{
		form.setId(customerContact.getId());
		form.setCustomerId(customerContact.getCustomerId());
		form.setContact(customerContact.getContact());
		form.setPosition(customerContact.getPosition());
		form.setTelephone(customerContact.getTelephone());
		form.setFax(customerContact.getFax());
		form.setMobile(customerContact.getMobile());
		form.setEmail(customerContact.getEmail());
		form.setPurchaseRole(customerContact.getPurchaseRole());
	}
	
	public void toCustomerContactModel(CustomerContactForm form, CustomerContact customerContact)
	{
		customerContact.setId(form.getId());
		customerContact.setCustomerId(form.getCustomerId());
		customerContact.setContact(form.getContact());
		customerContact.setPosition(form.getPosition());
		customerContact.setTelephone(form.getTelephone());
		customerContact.setFax(form.getFax());
		customerContact.setMobile(form.getMobile());
		customerContact.setEmail(form.getEmail());
		customerContact.setPurchaseRole(form.getPurchaseRole());	
	}	
}
