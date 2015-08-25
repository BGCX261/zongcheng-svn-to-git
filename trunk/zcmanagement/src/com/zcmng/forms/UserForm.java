package com.zcmng.forms;

/**
 * @author sunk
 *
 */
public class UserForm
{
	private int id;
	private String loginId;
	private String loginPwd;
	private String confirmPwd;
	private String userName;
	//TODO should refactor using Date type
	private String createDate;
	//TODO should refactor using Date type
	private String modifyDate;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
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
	
	public String getCreateDate()
	{
		return createDate;
	}
	
	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}
	
	public String getModifyDate()
	{
		return modifyDate;
	}
	
	public void setModifyDate(String modifyDate)
	{
		this.modifyDate = modifyDate;
	}

	public String getConfirmPwd()
	{
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd)
	{
		this.confirmPwd = confirmPwd;
	}
	
}
