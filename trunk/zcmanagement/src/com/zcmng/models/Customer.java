package com.zcmng.models;

import java.util.List;


/**
 * @author sunk
 *
 */
@SuppressWarnings("serial")
public class Customer extends BaseModel
{
	private String companyName;
	private String attribute;
	private String region;
	private String field;
	private String major;
	private String address;
	private String url;
    private List<CustomerContact> customerContacts;
    private List<CustomerProject> customerProjects;
	private int orderCount;
	private double orderMoney;
	private String paymentWay;
	private String creditLevel;
	private int disable;
	private Contact owner;
	
	public String getCompanyName()
	{
		return companyName;
	}
	
	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}
	
	public int getDisable()
	{
		return disable;
	}
	
	public void setDisable(int disable)
	{
		this.disable = disable;
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

	public List<CustomerContact> getCustomerContacts() 
	{
		return customerContacts;
	}

	public void setCustomerContacts(List<CustomerContact> customerContacts) 
	{
		this.customerContacts = customerContacts;
	}

	public List<CustomerProject> getCustomerProjects() 
	{
		return customerProjects;
	}

	public void setCustomerProjects(List<CustomerProject> customerProjects) 
	{
		this.customerProjects = customerProjects;
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

	public Contact getOwner() {
		return owner;
	}

	public void setOwner(Contact owner) {
		this.owner = owner;
	}
	
}
