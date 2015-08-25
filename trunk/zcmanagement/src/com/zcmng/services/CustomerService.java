package com.zcmng.services;

import java.util.List;
import java.util.Map;

import com.zcmng.models.Customer;
import com.zcmng.models.CustomerContact;
import com.zcmng.models.CustomerProject;

/**
 * @author sunk
 *
 */
public interface CustomerService
{
  /**
   * Find some Customers by conditions for pagination
	 *
   * @return
   * @throws Exception
   */
	public List<Customer> findCustomersForPagination(Map<String, Object> pagiMap) throws Exception;
	
	/**
	 * Count Customers
	 * 
	 * @return
	 * @throws Exception
	 */
	public int getCustomersCountByCondition(Map<String, Object> pagiMap) throws Exception;
	
	/**
	 * Find all customers
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Customer> findAllCustomers() throws Exception;
	
	/**
	 * Find Customer by Id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */	
	public Customer findCustomerById(int id) throws Exception;
	
	/**
	 * Insert/Update an Customer
	 * 
	 * @param Customer
	 * @throws Exception
	 */	
	public void insertOrUpdateCustomer(Customer customer) throws Exception;
	
	/**
	 * Delete some Customers in batch
	 * 
	 * @param customerIds
	 * @throws Exception
	 */	
	public void deleteCustomers(String customerIds) throws Exception;
	
	/**
	 * Find a CustomerContact By Id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public CustomerContact findCustomerContactById(int id) throws Exception;
	
	/**
	 * Find some CustomerContacts By CustomerId 
	 * 
	 * @param customerId
	 * @return
	 * @throws Exception
	 */
	public List<CustomerContact> findCustomerContactsByCustomerId(int customerId) throws Exception;
	
	/**
	 * Insert/Update an CustomerContact
	 * 
	 * @param customerContact
	 * @throws Exception
	 */
	public void insertOrUpdateCustomerContact(CustomerContact customerContact) throws Exception;
	
	/**
	 * Delete some CustomerContacts in batch
	 * 
	 * @param customerContactIds
	 * @throws Exception
	 */
	public void deleteCustomerContacts(String customerContactIds) throws Exception;
	
	/**
	 * Find a CustomerProject By Id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public CustomerProject findCustomerProjectById(int id) throws Exception;
	
	/**
	 * Find some CustomerProjects By CustomerId 
	 * 
	 * @param customerId
	 * @return
	 * @throws Exception
	 */
	public List<CustomerProject> findCustomerProjectsByCustomerId(int customerId) throws Exception;
	
	/**
	 * Insert/Update an CustomerProject
	 * 
	 * @param customerProject
	 * @throws Exception
	 */
	public void insertOrUpdateCustomerProject(CustomerProject customerProject) throws Exception;
	
	/**
	 * Delete some CustomerProjects in batch
	 * 
	 * @param customerProjectIds
	 * @throws Exception
	 */
	public void deleteCustomerProjects(String customerProjectIds) throws Exception;
}
