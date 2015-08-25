package com.zcmng.daos.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.zcmng.commons.Constants;
import com.zcmng.daos.DailyReportDao;
import com.zcmng.models.DailyReport;

/**
 * @author sunk
 *
 */
public class DailyReportDaoImpl extends SqlMapClientDaoSupport implements
		DailyReportDao
{
	@SuppressWarnings("unchecked")
	public List<DailyReport> findAllDailyReports(Map<String, Object> pagiMap) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		return (List<DailyReport>)sqlMap.queryForList("DailyReport.findDailyReportsByCondition", pagiMap);
	}
	
	public int getDailyReportsCountByCondition() throws SQLException
	{		
		SqlMapClient sqlMap = this.getSqlMapClient();
		return (Integer)sqlMap.queryForObject("DailyReport.getDailyReportCountByConditions");
	}
	
	public DailyReport findDailyReportById(int id) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		return (DailyReport)sqlMap.queryForObject("DailyReport.findDailyReportById",	id);
	}
	
	public void insertDailyReport(DailyReport dailyReport) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		sqlMap.insert("DailyReport.insert", dailyReport);
	}
	
	public void updateDailyReport(DailyReport dailyReport) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		sqlMap.update("DailyReport.update", dailyReport);		
	}
	
	public void deleteDailyReport(DailyReport dailyReport) throws SQLException
	{
		SqlMapClient sqlMap = this.getSqlMapClient();
		sqlMap.delete("DailyReport.delete", dailyReport);			
	}
	
	public void deleteDailyReportByIds(String dailyReportIds) throws SQLException
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dailyReportIds", dailyReportIds.split(Constants.COMMA_STRING));
		
		SqlMapClient sqlMap = this.getSqlMapClient();
		sqlMap.delete("DailyReport.deleteDailyReportByIds", map);			
	}	
}
