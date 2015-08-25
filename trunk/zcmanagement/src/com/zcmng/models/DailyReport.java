package com.zcmng.models;


/**
 * @author sunk
 *
 */
@SuppressWarnings("serial")
public class DailyReport extends BaseModel
{
	private Contact user;
	private Customer customer;
	private String task;
	private String notes;
	private String publishDate;	
	
	public Contact getUser()
	{
		return user;
	}
	
	public void setUser(Contact user)
	{
		this.user = user;
	}
	
	public Customer getCustomer()
	{
		return customer;
	}
	
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
	
	public String getTask()
	{
		return task;
	}
	
	public void setTask(String task)
	{
		this.task = task;
	}
	
	public String getNotes()
	{
		return notes;
	}
	
	public void setNotes(String notes)
	{
		this.notes = notes;
	}
	
	public String getPublishDate() 
	{
		return publishDate;
	}

	public void setPublishDate(String publishDate) 
	{
		this.publishDate = publishDate;
	}
	
}
