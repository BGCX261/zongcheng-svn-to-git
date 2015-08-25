package com.zcmng.daos;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.zcmng.models.Contact;

/**
 * @author sunk
 *
 */
public interface UserDao
{
	/**
	 * Find User By LoginId and Password
	 * 
	 * @param loginId
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public Contact findUserByIdAndPwd(String loginId, String loginPwd) throws SQLException;
	
	/**
	 * Find Users by conditions for pagination
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Contact> findAllUsers(Map<String, Object> pagiMap) throws SQLException;
	
	/**
	 * Count User
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int getUsersCountByCondition() throws SQLException;
	
	/**
	 * Find User by Id
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Contact findUserById(int id) throws SQLException;
	
	/**
	 * Insert new User
	 * 
	 * @param user
	 * @throws SQLException
	 */
	public void insertUser(Contact user) throws SQLException;
	
	/**
	 * Update an User
	 * 
	 * @param user
	 * @throws SQLException
	 */
	public void updateUser(Contact user) throws SQLException;
	
	/**
	 * Delete an User
	 * 
	 * @param user
	 * @throws SQLException
	 */
	public void deleteUser(Contact user) throws SQLException;
	
	/**
	 * Delete some Users in batch
	 * 
	 * @param userIds
	 * @throws SQLException
	 */
	public void deleteUserByIds(String userIds) throws SQLException;
	
	/**
	 * Count User by loginId
	 * 
	 * @param loginId
	 * @return
	 * @throws SQLException
	 */
	public Integer getContactCountByLoginId(String loginId) throws SQLException;

}
