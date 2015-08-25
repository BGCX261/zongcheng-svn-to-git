package com.zcmng.forms;

import com.zcmng.models.Contact;

/**
 * @author sunk
 *
 */
public class UserMapper
{
	public void toUserForm(Contact user, UserForm userForm)
	{
		userForm.setId(user.getId());
		userForm.setLoginId(user.getLoginId());
		userForm.setLoginPwd(user.getLoginPwd());
		userForm.setUserName(user.getUserName());
		userForm.setCreateDate(user.getCreateDate());
		userForm.setModifyDate(user.getModifyDate());
	}
	
	public void toUserModel(UserForm userForm, Contact user)
	{
		user.setId(userForm.getId());
		user.setLoginId(userForm.getLoginId());
		user.setLoginPwd(userForm.getLoginPwd());
		user.setUserName(userForm.getUserName());
	}	
}
