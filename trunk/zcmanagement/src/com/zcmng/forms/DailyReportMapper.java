package com.zcmng.forms;

import com.zcmng.models.Contact;
import com.zcmng.models.Customer;
import com.zcmng.models.DailyReport;

/**
 * @author sunk
 *
 */
public class DailyReportMapper
{	
	public void toDailyReportForm(DailyReport dailyReport, DailyReportForm form)
	{
		form.setId(dailyReport.getId());
		
		Contact user = dailyReport.getUser();
		form.setUserId(user.getId());
		form.setUserName(user.getUserName());
		
		Customer customer = dailyReport.getCustomer();
		form.setCustomerId(customer.getId());
		form.setCompanyName(customer.getCompanyName());
		
		form.setTask(dailyReport.getTask());
		form.setNotes(dailyReport.getNotes());
		form.setPublishDate(dailyReport.getPublishDate());

	}
	
	public void toDailyReportModel(DailyReportForm form, DailyReport dailyReport)
	{
		dailyReport.setId(form.getId());
		
		Customer customer = new Customer();
		customer.setId(form.getCustomerId());
		customer.setCompanyName(form.getCompanyName());
		dailyReport.setCustomer(customer);
		
		dailyReport.setTask(form.getTask());
		dailyReport.setNotes(form.getNotes());
		dailyReport.setPublishDate(form.getPublishDate());
	}
}
