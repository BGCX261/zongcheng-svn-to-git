package com.zcmng.models;


/**
 * @author sunk
 *
 */
@SuppressWarnings("serial")
public class CustomerProject extends BaseModel
{
	private int customerId;
	private String projectRequirement;
	private String productRequirement;
	private double price;
	private String competition;
	private double competitionPrice;
	private String communicationDate;
	private String communicationNotes;
	
	public int getCustomerId() 
	{
		return customerId;
	}

	public void setCustomerId(int customerId) 
	{
		this.customerId = customerId;
	}

	public String getProjectRequirement() 
	{
		return projectRequirement;
	}
	
	public void setProjectRequirement(String projectRequirement) 
	{
		this.projectRequirement = projectRequirement;
	}
	
	public String getProductRequirement() 
	{
		return productRequirement;
	}
	
	public void setProductRequirement(String productRequirement) 
	{
		this.productRequirement = productRequirement;
	}
	
	public double getPrice() 
	{
		return price;
	}
	
	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	public String getCompetition() 
	{
		return competition;
	}
	
	public void setCompetition(String competition) 
	{
		this.competition = competition;
	}
	
	public double getCompetitionPrice() 
	{
		return competitionPrice;
	}
	
	public void setCompetitionPrice(double competitionPrice) 
	{
		this.competitionPrice = competitionPrice;
	}
	
	public String getCommunicationDate() 
	{
		return communicationDate;
	}
	
	public void setCommunicationDate(String communicationDate) 
	{
		this.communicationDate = communicationDate;
	}
	
	public String getCommunicationNotes() 
	{
		return communicationNotes;
	}
	
	public void setCommunicationNotes(String communicationNotes) 
	{
		this.communicationNotes = communicationNotes;
	}

	
}
