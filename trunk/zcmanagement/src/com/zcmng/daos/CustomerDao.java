package com.zcmng.daos;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.zcmng.models.Customer;
import com.zcmng.models.CustomerContact;
import com.zcmng.models.CustomerProject;

/**
 * @author sunk
 *
 */
public interface CustomerDao
{
	/**
	 * Find Customers by conditions for pagination
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Customer> findCustomersForPagination(Map<String, Object> pagiMap) throws SQLException;
	
	/**
	 * Count Customers
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int getCustomersCountByCondition(Map<String, Object> pagiMap) throws SQLException;
	
	/**
	 * Find all Customers
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Customer> findAllCustomers() throws SQLException;
	
	/**
	 * Find Customer by Id
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Customer findCustomerById(int id) throws SQLException;
	
	/**
	 * Insert a Customer
	 * 
	 * @param customer
	 * @throws SQLException
	 */
	public void insertCustomer(Customer customer) throws SQLException;
	
	/**
	 * Update a Customer
	 * 
	 * @param customer
	 * @throws SQLException
	 */
	public void updateCustomer(Customer customer) throws SQLException;
	
	/**
	 * Delete a Customer
	 * 
	 * @param customer
	 * @throws SQLException
	 */
	public void deleteCustomer(Customer customer) throws SQLException;
	
	/**
	 * Delete some Customers in batch
	 * 
	 * @param customerIds
	 * @throws SQLException
	 */
	public void deleteCustomerByIds(int[] cusIds) throws SQLException;
	
	/**
	 * Find a CustomerContact By Id
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public CustomerContact findCustomerContactById(int id) throws SQLException;
	
	/**
	 * Find some CustomerContacts by customerId
	 * 
	 * @param customerId
	 * @return
	 * @throws SQLException
	 */
	public List<CustomerContact> findCustomerContactsByCustomerId(int customerId) throws SQLException;
	
	/**
	 * Insert a CustomerContact
	 * 
	 * @param customerContact
	 * @throws SQLException
	 */
	public void insertCustomerContact(CustomerContact customerContact) throws SQLException;
	
	/**
	 * Update a CustomerContact
	 * 
	 * @param customerContact
	 * @throws SQLException
	 */
	public void updateCustomerContact(CustomerContact customerContact) throws SQLException;
	
	/**
	 * Delete some CustomerProjects
	 * 
	 * @param customerContact
	 * @throws SQLException
	 */
	public void deleteCustomerContactByIds(int[] ccIds) throws SQLException;
	
	/**
	 * Find a CustomerProject By Id
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public CustomerProject findCustomerProjectById(int id) throws SQLException;
	
	/**
	 * Find some CustomerProjects By customerId
	 * 
	 * @param customerId
	 * @return
	 * @throws SQLException
	 */
	public List<CustomerProject> findCustomerProjectsByCustomerId(int customerId) throws SQLException;
	
	/**
	 * Insert a CustomerProject
	 * 
	 * @param customerProject
	 * @throws SQLException
	 */
	public void insertCustomerProject(CustomerProject customerProject) throws SQLException;
	
	/**
	 * Update a CustomerProject
	 * 
	 * @param customerProject
	 * @throws SQLException
	 */
	public void updateCustomerProject(CustomerProject customerProject) throws SQLException;
	
	/**
	 * Delete some CustomerProjects
	 * 
	 * @param customerProject
	 * @throws SQLException
	 */
	public void deleteCustomerProjectByIds(int[] cpIds) throws SQLException;
}
