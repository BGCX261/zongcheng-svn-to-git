package com.zcmng.forms;

import com.zcmng.models.Customer;

/**
 * @author sunk
 *
 */
public class CustomerMapper
{

	public void toCustomerForm(Customer customer, CustomerForm form)
	{
		form.setId(customer.getId());
		form.setCompanyName(customer.getCompanyName());
		form.setAttribute(customer.getAttribute());
		form.setRegion(customer.getRegion());
		form.setField(customer.getField());
		form.setMajor(customer.getMajor());
		form.setAddress(customer.getAddress());
		form.setUrl(customer.getUrl());
		form.setCustomerContactSize(customer.getCustomerContacts().size());
		form.setCustomerProjectSize(customer.getCustomerProjects().size());
		form.setOrderCount(customer.getOrderCount());
		form.setOrderMoney(customer.getOrderMoney());
		form.setPaymentWay(customer.getPaymentWay());
		form.setCreditLevel(customer.getCreditLevel());
		
		form.setOwnerName(customer.getOwner().getUserName());
	}
	
	public void toCustomerModel(CustomerForm form, Customer customer)
	{
		customer.setId(form.getId());
		customer.setCompanyName(form.getCompanyName());
		customer.setAttribute(form.getAttribute());
		customer.setRegion(form.getRegion());
		customer.setField(form.getField());
		customer.setMajor(form.getMajor());
		customer.setAddress(form.getAddress());
		customer.setUrl(form.getUrl());
		customer.setOrderCount(form.getOrderCount());
		customer.setOrderMoney(form.getOrderMoney());
		customer.setPaymentWay(form.getPaymentWay());
		customer.setCreditLevel(form.getCreditLevel());		
	}	
}
