package com.zcmng.forms;

/**
 * @author sunk
 *
 */
public class CustomerContactForm
{
	private int id;
	private int customerId;
	private String contact;
	private String position;
	private String telephone;
	private String fax;
	private String mobile;
	private String email;
	private String purchaseRole;	
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}	
	
	public int getCustomerId() 
	{
		return customerId;
	}
	
	public void setCustomerId(int customerId) 
	{
		this.customerId = customerId;
	}
	
	public String getContact() 
	{
		return contact;
	}
	
	public void setContact(String contact) 
	{
		this.contact = contact;
	}
	
	public String getPosition() 
	{
		return position;
	}
	
	public void setPosition(String position) 
	{
		this.position = position;
	}
	
	public String getTelephone() 
	{
		return telephone;
	}
	
	public void setTelephone(String telephone) 
	{
		this.telephone = telephone;
	}
	
	public String getFax() 
	{
		return fax;
	}
	
	public void setFax(String fax) 
	{
		this.fax = fax;
	}
	
	public String getMobile() 
	{
		return mobile;
	}
	
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getPurchaseRole() 
	{
		return purchaseRole;
	}
	
	public void setPurchaseRole(String purchaseRole) 
	{
		this.purchaseRole = purchaseRole;
	}
}
