package com.zcmng.models;


/**
 * @author sunk
 *
 */
@SuppressWarnings("serial")
public class Contact extends BaseModel
{
	private String loginId;
	private String loginPwd;
	private String userName;

	private int disable;
	
	public String getLoginId()
	{
		return loginId;
	}
	
	public void setLoginId(String loginId)
	{
		this.loginId = loginId;
	}
	
	public String getLoginPwd()
	{
		return loginPwd;
	}
	
	public void setLoginPwd(String loginPwd)
	{
		this.loginPwd = loginPwd;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public int getDisable()
	{
		return disable;
	}
	
	public void setDisable(int disable)
	{
		this.disable = disable;
	}	
	
}
