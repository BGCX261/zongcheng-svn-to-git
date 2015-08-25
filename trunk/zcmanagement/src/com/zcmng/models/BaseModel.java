package com.zcmng.models;

import java.io.Serializable;

/**
 * @author sunk
 *
 */
@SuppressWarnings("serial")
public class BaseModel implements Serializable
{
	private int id;
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

}