package com.zcmng.daos.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.zcmng.commons.Constants;
import com.zcmng.daos.UserDao;
import com.zcmng.models.Contact;

/**
 * @author sunk
 *
 */
public class UserDaoImpl extends SqlMapClientDaoSupport implements UserDao
{
	public Contact findUserByIdAndPwd(String loginId, String loginPwd) throws SQLException
	{
		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("loginId", loginId);
		map.put("loginPwd", loginPwd);
		
		SqlMapClient sqlMap = this.getSqlMapClient();
		Object result = sqlMap.queryForObject("Contact.findContactByIdAndPwd",	map);

		return (Contact) result;		
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> findAllUsers(Map<String, Object> pagiMap) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		return (List<Contact>)sqlMap.queryForList("Contact.findContactsByCondition", pagiMap);
	}
	
	public int getUsersCountByCondition() throws SQLException
	{		
		SqlMapClient sqlMap = this.getSqlMapClient();
		return (Integer)sqlMap.queryForObject("Contact.getContactCountByConditions");
	}	
	
	public Contact findUserById(int id) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		return (Contact)sqlMap.queryForObject("Contact.findContactById", id);
	}
	
	public void insertUser(Contact user) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		sqlMap.insert("Contact.insert", user);
	}
	
	public void updateUser(Contact user) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		sqlMap.update("Contact.update", user);		
	}
	
	public void deleteUser(Contact user) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		sqlMap.delete("Contact.delete", user);			
	}
	
	public void deleteUserByIds(String userIds) throws SQLException
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("contactIds", userIds.split(Constants.COMMA_STRING));
		
		SqlMapClient sqlMap = this.getSqlMapClient();
		sqlMap.delete("Contact.deleteContactByIds", map);			
	}	
	
	public Integer getContactCountByLoginId(String loginId) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		return (Integer)sqlMap.queryForObject("Contact.getContactCountByLoginId", loginId);		
	}
}
