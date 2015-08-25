package com.zcmng.forms;

import com.zcmng.models.CustomerProject;

/**
 * @author sunk
 *
 */
public class CustomerProjectMapper
{

	public void toCustomerProjectForm(CustomerProject customerProject, CustomerProjectForm form)
	{
		form.setId(customerProject.getId());
		form.setCustomerId(customerProject.getCustomerId());
		form.setProjectRequirement(customerProject.getProjectRequirement());
		form.setProductRequirement(customerProject.getProductRequirement());
		form.setPrice(customerProject.getPrice());
		form.setCompetition(customerProject.getCompetition());
		form.setCompetitionPrice(customerProject.getCompetitionPrice());
		form.setCommunicationDate(customerProject.getCommunicationDate());
		form.setCommunicationNotes(customerProject.getCommunicationNotes());
	}
	
	public void toCustomerProjectModel(CustomerProjectForm form, CustomerProject customerProject)
	{
		customerProject.setId(form.getId());
		customerProject.setCustomerId(form.getCustomerId());
		customerProject.setProjectRequirement(form.getProjectRequirement());
		customerProject.setProductRequirement(form.getProductRequirement());
		customerProject.setPrice(form.getPrice());
		customerProject.setCompetition(form.getCompetition());
		customerProject.setCompetitionPrice(form.getCompetitionPrice());
		customerProject.setCommunicationDate(form.getCommunicationDate());
		customerProject.setCommunicationNotes(form.getCommunicationNotes());
	}	
}
