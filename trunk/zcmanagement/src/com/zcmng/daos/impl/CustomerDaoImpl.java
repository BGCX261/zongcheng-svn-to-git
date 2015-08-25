package com.zcmng.daos.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.zcmng.daos.CustomerDao;
import com.zcmng.models.Customer;
import com.zcmng.models.CustomerContact;
import com.zcmng.models.CustomerProject;

/**
 * @author sunk
 *
 */
public class CustomerDaoImpl extends SqlMapClientDaoSupport implements CustomerDao
{
	@SuppressWarnings("unchecked")
	public List<Customer> findCustomersForPagination(Map<String, Object> pagiMap) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		return (List<Customer>)sqlMap.queryForList("Customer.findCustomersByCondition", pagiMap);
	}
	
	public int getCustomersCountByCondition(Map<String, Object> pagiMap) throws SQLException
	{		
		SqlMapClient sqlMap = this.getSqlMapClient();
		return (Integer)sqlMap.queryForObject("Customer.getCustomerCountByConditions", pagiMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> findAllCustomers() throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		return (List<Customer>)sqlMap.queryForList("Customer.findAllCustomers");
	}	
	
	public Customer findCustomerById(int id) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		return (Customer)sqlMap.queryForObject("Customer.findCustomerById",	id);
	}
	
	public void insertCustomer(Customer customer) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		sqlMap.insert("Customer.insert", customer);
	}
	
	public void updateCustomer(Customer customer) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		sqlMap.update("Customer.update", customer);		
	}
	
	public void deleteCustomer(Customer customer) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		sqlMap.delete("Customer.delete", customer);			
	}
	
	public void deleteCustomerByIds(int[] cusIds) throws SQLException
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("customerIds",cusIds);
		
		SqlMapClient sqlMap = this.getSqlMapClient();
		sqlMap.delete("Customer.deleteCustomerByIds", map);			
	}
	
	public CustomerContact findCustomerContactById(int id) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		return (CustomerContact)sqlMap.queryForObject("CustomerContact.findCustomerContactById", id);
	}	
	
	@SuppressWarnings("unchecked")
	public List<CustomerContact> findCustomerContactsByCustomerId(int customerId) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		return (List<CustomerContact>)sqlMap.queryForList("CustomerContact.findCustomerContactsByCustomerId", customerId);
	}	
	
	public void insertCustomerContact(CustomerContact customerContact) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		sqlMap.insert("CustomerContact.insert", customerContact);		
	}
	
	public void updateCustomerContact(CustomerContact customerContact) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		sqlMap.update("CustomerContact.update", customerContact);		
	}
	
	public void deleteCustomerContactByIds(int[] ccIds) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("customerConatctIds",ccIds);
		sqlMap.delete("CustomerContact.delete", map);			
	}

	public CustomerProject findCustomerProjectById(int id) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		return (CustomerProject)sqlMap.queryForObject("CustomerProject.findCustomerProjectById", id);
	}	
	
	@SuppressWarnings("unchecked")
	public List<CustomerProject> findCustomerProjectsByCustomerId(int customerId) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		return (List<CustomerProject>)sqlMap.queryForList("CustomerProject.findCustomerProjectsByCustomerId", customerId);
	}	
	
	public void insertCustomerProject(CustomerProject customerProject) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		sqlMap.insert("CustomerProject.insert", customerProject);		
	}
	
	public void updateCustomerProject(CustomerProject customerProject) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		sqlMap.update("CustomerProject.update", customerProject);		
	}
	
	public void deleteCustomerProjectByIds(int[] cpIds) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("customerProjectIds",cpIds);		
		sqlMap.delete("CustomerProject.delete", map);			
	}	
}
