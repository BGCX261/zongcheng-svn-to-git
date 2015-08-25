package com.zcmng.services.impl;

import java.util.List;
import java.util.Map;

import com.zcmng.daos.DailyReportDao;
import com.zcmng.models.DailyReport;
import com.zcmng.services.DailyReportService;

/**
 * @author sunk
 *
 */
public class DailyReportServiceImpl implements DailyReportService
{
	private DailyReportDao dailyReportDao;
	
	public DailyReportServiceImpl(DailyReportDao dailyReportDao)
	{
		this.dailyReportDao = dailyReportDao;
	}
	
	public List<DailyReport> findAllDailyReports(Map<String, Object> pagiMap) throws Exception
	{
		return dailyReportDao.findAllDailyReports(pagiMap);
	}
	
	public Integer getDailyReportsCountByCondition() throws Exception
	{
		return dailyReportDao.getDailyReportsCountByCondition();
	}	
	
	public DailyReport findDailyReportById(int id) throws Exception
	{
		return dailyReportDao.findDailyReportById(id);
	}
	
	public void insertOrUpdateDailyReport(DailyReport dailyReport) throws Exception
	{
		if(dailyReport.getId() == 0)
		{
			dailyReportDao.insertDailyReport(dailyReport);
		}
		else
		{
			dailyReportDao.updateDailyReport(dailyReport);
		}		
	}
	
	public void deleteDailyReports(String dailyReportIds) throws Exception
	{
		dailyReportDao.deleteDailyReportByIds(dailyReportIds);
	}		
}
