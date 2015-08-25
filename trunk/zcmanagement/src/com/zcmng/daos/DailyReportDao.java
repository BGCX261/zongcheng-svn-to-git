package com.zcmng.daos;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.zcmng.models.DailyReport;

/**
 * @author sunk
 *
 */
public interface DailyReportDao
{
	/**
	 * Find all DailyReports
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<DailyReport> findAllDailyReports(Map<String, Object> pagiMap) throws SQLException;
	
	/**
	 * Count DailyReports
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int getDailyReportsCountByCondition() throws SQLException;
	
	/**
	 * Find DailyReport by Id
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public DailyReport findDailyReportById(int id) throws SQLException;
	
	/**
	 * Insert a DailyReport
	 * 
	 * @param dailyReport
	 * @throws SQLException
	 */
	public void insertDailyReport(DailyReport dailyReport) throws SQLException;
	
	/**
	 * Update a DailyReport
	 * 
	 * @param dailyReport
	 * @throws SQLException
	 */
	public void updateDailyReport(DailyReport dailyReport) throws SQLException;
	
	/**
	 * Delete a DailyReport
	 * 
	 * @param dailyReport
	 * @throws SQLException
	 */
	public void deleteDailyReport(DailyReport dailyReport) throws SQLException;
	
	/**
	 * Delete some DailyReport by ids
	 * 
	 * @param dailyReportIds
	 * @throws SQLException
	 */
	public void deleteDailyReportByIds(String dailyReportIds) throws SQLException;
}
