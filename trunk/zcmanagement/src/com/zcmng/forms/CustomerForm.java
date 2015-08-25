package com.zcmng.forms;

/**
 * @author sunk
 *
 */
public class CustomerForm
{
	private int id;
	private String companyName;
	private String attribute;
	private String region;
	private String field;
	private String major;
	private String address;
	private String url;
    private int customerContactSize;
    private int customerProjectSize;
	private int orderCount;
	private double orderMoney;
	private String paymentWay;
	private String creditLevel;	
	
	private String ownerName;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getCompanyName()
	{
		return companyName;
	}
	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}
	
	public String getAttribute() 
	{
		return attribute;
	}
	
	public void setAttribute(String attribute) 
	{
		this.attribute = attribute;
	}
	
	public String getRegion() 
	{
		return region;
	}
	
	public void setRegion(String region) 
	{
		this.region = region;
	}
	
	public String getField() 
	{
		return field;
	}
	
	public void setField(String field) 
	{
		this.field = field;
	}
	
	public String getMajor() 
	{
		return major;
	}
	
	public void setMajor(String major) 
	{
		this.major = major;
	}
	
	public String getAddress() 
	{
		return address;
	}
	
	public void setAddress(String address) 
	{
		this.address = address;
	}
	
	public String getUrl() 
	{
		return url;
	}
	
	public void setUrl(String url) 
	{
		this.url = url;
	}
	
	public int getCustomerContactSize() 
	{
		return customerContactSize;
	}
	
	public void setCustomerContactSize(int customerContactSize) 
	{
		this.customerContactSize = customerContactSize;
	}
	
	public int getCustomerProjectSize() 
	{
		return customerProjectSize;
	}
	
	public void setCustomerProjectSize(int customerProjectSize) 
	{
		this.customerProjectSize = customerProjectSize;
	}
	
	public int getOrderCount() 
	{
		return orderCount;
	}
	
	public void setOrderCount(int orderCount) 
	{
		this.orderCount = orderCount;
	}
	
	public double getOrderMoney() 
	{
		return orderMoney;
	}
	
	public void setOrderMoney(double orderMoney) 
	{
		this.orderMoney = orderMoney;
	}
	
	public String getPaymentWay() 
	{
		return paymentWay;
	}
	
	public void setPaymentWay(String paymentWay) 
	{
		this.paymentWay = paymentWay;
	}
	
	public String getCreditLevel() 
	{
		return creditLevel;
	}
	
	public void setCreditLevel(String creditLevel) 
	{
		this.creditLevel = creditLevel;
	}
	
	public String getOwnerName() 
	{
		return ownerName;
	}
	
	public void setOwnerName(String ownerName) 
	{
		this.ownerName = ownerName;
	}

}
