package com.zcmng.services;

import java.util.List;
import java.util.Map;

import com.zcmng.models.Contact;

/**
 * @author sunk
 *
 */
public interface UserService
{
  /**
   * Find Contact By LoginId and Password
   * 
   * @param loginId
   * @param loginPwd
   * @return
   * @throws Exception
   */
	public Contact findUserByIdAndPwd(String loginId, String loginPwd) throws Exception;
	
	/**
	 * Find Users by conditions for pagination
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Contact> findAllUsers(Map<String, Object> pagiMap) throws Exception;
	
	/**
	 * Count User
	 * 
	 * @return
	 * @throws Exception
	 */
	public int getUsersCountByCondition() throws Exception;
	
	/**
	 * Find User by Id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Contact findUserById(int id) throws Exception;
	
	/**
	 * Insert/Update an User
	 * 
	 * @param user
	 * @throws Exception
	 */
	public void insertOrUpdateUser(Contact user) throws Exception;
	
	/**
	 * Delete some Users in batch
	 * 
	 * @param user
	 * @throws Exception
	 */
	public void deleteUsers(String userIds) throws Exception;
	
	/**
	 * Count User by loginId
	 * 
	 * @param loginId
	 * @return
	 * @throws Exception
	 */
	public Integer getContactCountByLoginId(String loginId) throws Exception;
}
