package com.zcmng.services.impl;

import java.util.List;
import java.util.Map;

import com.zcmng.daos.UserDao;
import com.zcmng.models.Contact;
import com.zcmng.services.UserService;

/**
 * @author sunk
 *
 */
public class UserServiceImpl implements UserService
{
	private UserDao userDao;
	
	public UserServiceImpl(UserDao userDao)
	{
		this.userDao = userDao;
	}
	
	public Contact findUserByIdAndPwd(String loginId, String loginPwd) throws Exception
	{
		return userDao.findUserByIdAndPwd(loginId, loginPwd);
	}
	
	public List<Contact> findAllUsers(Map<String, Object> pagiMap) throws Exception
	{
		return userDao.findAllUsers(pagiMap);
	}
	
	public int getUsersCountByCondition() throws Exception
	{
		return userDao.getUsersCountByCondition();
	}	
	
	public Contact findUserById(int id) throws Exception
	{
		return userDao.findUserById(id);
	}
	
	public void insertOrUpdateUser(Contact user) throws Exception
	{
		if(user.getId() == 0)
		{
			userDao.insertUser(user);
		}
		else
		{
			userDao.updateUser(user);
		}		
	}
	
	public void deleteUsers(String userIds) throws Exception
	{
		userDao.deleteUserByIds(userIds);
	}
	
	public Integer getContactCountByLoginId(String loginId) throws Exception
	{
		return userDao.getContactCountByLoginId(loginId);
	}
}
