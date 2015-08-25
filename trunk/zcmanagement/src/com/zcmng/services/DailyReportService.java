package com.zcmng.services;

import java.util.List;
import java.util.Map;

import com.zcmng.models.DailyReport;

/**
 * @author sunk
 *
 */
public interface DailyReportService
{
	/**
	 * Find all DailyReports
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<DailyReport> findAllDailyReports(Map<String, Object> pagiMap) throws Exception;
	
	/**
	 * Count DailyReports
	 * 
	 * @return
	 * @throws Exception
	 */
	public Integer getDailyReportsCountByCondition() throws Exception;
	
	/**
	 * Find a DailyReport by id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public DailyReport findDailyReportById(int id) throws Exception;
	
	/**
	 * Insert/Update a DailyReport
	 * 
	 * @param dailyReport
	 * @throws Exception
	 */
	public void insertOrUpdateDailyReport(DailyReport dailyReport) throws Exception;
	
	/**
	 * Delete a DailyReport
	 * 
	 * @param dailyReportIds
	 * @throws Exception
	 */
	public void deleteDailyReports(String dailyReportIds) throws Exception;
}
