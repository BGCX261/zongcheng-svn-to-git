package com.zcmng.services.impl;

import java.util.List;
import java.util.Map;

import com.zcmng.commons.Constants;
import com.zcmng.daos.CustomerDao;
import com.zcmng.models.Customer;
import com.zcmng.models.CustomerContact;
import com.zcmng.models.CustomerProject;
import com.zcmng.services.CustomerService;

/**
 * @author sunk
 *
 */
public class CustomerServiceImpl implements CustomerService
{
	private CustomerDao customerDao;
	
	public CustomerServiceImpl(CustomerDao customerDao)
	{
		this.customerDao = customerDao;
	}	
	
	public List<Customer> findCustomersForPagination(Map<String, Object> pagiMap) throws Exception
	{
		return customerDao.findCustomersForPagination(pagiMap);
	}
	
	public int getCustomersCountByCondition(Map<String, Object> pagiMap) throws Exception
	{
		return customerDao.getCustomersCountByCondition(pagiMap);
	}
	
	public List<Customer> findAllCustomers() throws Exception
	{
		return customerDao.findAllCustomers();
	}	
	
	public Customer findCustomerById(int id) throws Exception
	{
		return customerDao.findCustomerById(id);
	}
	
	public void insertOrUpdateCustomer(Customer customer) throws Exception
	{
		if(customer.getId() == 0)
		{
			customerDao.insertCustomer(customer);
		}
		else
		{
			customerDao.updateCustomer(customer);
		}		
	}
	
	public void deleteCustomers(String customerIds) throws Exception
	{
		String[] idArray = customerIds.split(Constants.COMMA_STRING);
		int[] cusIds = new int[idArray.length];
		for(int i=0; i<idArray.length; i++)
		{
			cusIds[i] = Integer.parseInt(idArray[i]);
		}
		
		customerDao.deleteCustomerByIds(cusIds);
	}
	
	public CustomerContact findCustomerContactById(int id) throws Exception
	{
		return customerDao.findCustomerContactById(id);
	}	
	
	public List<CustomerContact> findCustomerContactsByCustomerId(int customerId) throws Exception
	{
		return customerDao.findCustomerContactsByCustomerId(customerId);
	}	
	
	public void insertOrUpdateCustomerContact(CustomerContact customerContact) throws Exception
	{
		if(customerContact.getId() == 0)
		{
			customerDao.insertCustomerContact(customerContact);
		}
		else
		{
			customerDao.updateCustomerContact(customerContact);
		}		
	}
	
	public void deleteCustomerContacts(String customerContactIds) throws Exception
	{
		String[] idArray = customerContactIds.split(Constants.COMMA_STRING);
		int[] ccIds = new int[idArray.length];
		for(int i=0; i<idArray.length; i++)
		{
			ccIds[i] = Integer.parseInt(idArray[i]);
		}
		
		customerDao.deleteCustomerContactByIds(ccIds);
	}
	
	public CustomerProject findCustomerProjectById(int id) throws Exception
	{
		return customerDao.findCustomerProjectById(id);
	}	
	
	public List<CustomerProject> findCustomerProjectsByCustomerId(int customerId) throws Exception
	{
		return customerDao.findCustomerProjectsByCustomerId(customerId);
	}	
	
	public void insertOrUpdateCustomerProject(CustomerProject customerProject) throws Exception
	{
		if(customerProject.getId() == 0)
		{
			customerDao.insertCustomerProject(customerProject);
		}
		else
		{
			customerDao.updateCustomerProject(customerProject);
		}		
	}
	
	public void deleteCustomerProjects(String customerProjectIds) throws Exception
	{
		String[] idArray = customerProjectIds.split(Constants.COMMA_STRING);
		int[] cpIds = new int[idArray.length];
		for(int i=0; i<idArray.length; i++)
		{
			cpIds[i] = Integer.parseInt(idArray[i]);
		}
		
		customerDao.deleteCustomerProjectByIds(cpIds);
	}	
}
