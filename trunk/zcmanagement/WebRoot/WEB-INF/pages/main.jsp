<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Welcome To ZongCheng</title>
<link href="./css/common.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
function forwardUpdate(obj)
{
	document.reportListForm.action = "forwardUpdateDailyReport.action?dailyReportId="+obj;
	document.reportListForm.submit();
}

function subDel()
{
	var reportIds = "";
	var delFlag = document.getElementsByName("delFlag");
	for(var i=0; i<delFlag.length; i++)
	{
		if(delFlag[i].checked)
		{
			reportIds += delFlag[i].value + ",";
		}
	}

	reportIds = reportIds.substring(0, reportIds.length-1);
	if(confirm("Are you sure?"))
	{
		document.reportListForm.action = "deleteDailyReport.action?deldailyReportIds="+reportIds;
		document.reportListForm.submit();			
	}
}

function loginOut()
{
	document.reportListForm.action = "loginOut.action";
	document.reportListForm.submit();	
}

function forwardCustomerUpdate()
{
	document.reportListForm.action = "viewCustomers.action";
	document.reportListForm.submit();
}

function viewDailyReports(obj)
{
	document.reportListForm.action = "viewDailyReports.action?currentPage="+obj;
	document.reportListForm.submit();	
}
</script>
</head>

<body>
<div id="menu">
  <div id="menu_box">
	<a href="#" class="m_on"><s:text name="zongcheng.label.reportManagement" /></a>
  </div>
</div>

<!-- error -->
<s:actionerror/>
<s:fielderror/>

<s:form name="reportListForm">
<div id="main">
  <div class="block1">
    <div class="block_add">
	    <input type="button" name="addNewsBtn" 
	    	value="<s:property value="getText('zongcheng.button.addBtn')"/>" 
	    	onclick="javascript:forwardUpdate()"/>    
    </div>
    
    <div class="block_add">
	    <input type="button" name="addCustomersBtn" 
	    	value="<s:property value="getText('zongcheng.button.viewCustomersBtn')"/>" 
	    	onclick="javascript:forwardCustomerUpdate()"/>    
    </div>    
 
  <!-- For Pagination -->
  <div class="block_index">
  <s:if test="null != #dailyReportList && !#dailyReportList.isEmpty()">
    <s:if test="#pagination.needShowFirstPage">
    	<a href="javascript:viewDailyReports(1)"><s:text name="zongcheng.label.firstPage" /></a>
    </s:if>
  	<s:iterator value="#pagiForm.pageNumbers">
  		<a href="javascript:viewDailyReports(<s:property/>)"><s:property/></a>
  	</s:iterator>
     <s:if test="#pagiForm.needShowLastPage">
    	<a href="javascript:viewDailyReports(<s:property value="#pagiForm.getTotalPageCount"/>)"><s:text name="zongcheng.label.lastPage" /></a>
    </s:if> 	
  </s:if>
  </div>

  </div>
  <s:if test="null != #dailyReportList && !#dailyReportList.isEmpty()">
  <table border="0" cellspacing="0" cellpadding="0" class="listtb">
    <tr class="listtb_t">
      <td><s:text name="zongcheng.label.publishDate" /></td>
      <td><s:text name="zongcheng.label.userName" /></td>
      <td><s:text name="zongcheng.label.customerName" /></td>
      <td><s:text name="zongcheng.label.task" /></td>
      <td><s:text name="zongcheng.label.notes" /></td>
      <td><s:text name="zongcheng.label.modify" /></td>
      <td><input type="button" name="delReportBtn" value="<s:property value="getText('zongcheng.button.deleteBtn')"/>" onclick="javascript:subDel()"/></td>      
    </tr>
    <s:iterator value="#dailyReportList" status="index">
    <tr <s:if test="#index.odd == true"> class="libg" </s:if> >
      <td><s:property value="publishDate"/></td>
      <td><s:property value="userName"/></td>
      <td><s:property value="companyName"/></td>
      <td><s:property value="task"/></td>
      <td><s:property value="notes"/></td>     
      <td class="lic_A"><a href="javascript:forwardUpdate(<s:property value="id"/>)"><s:text name="zongcheng.label.modify" /></a></td>
      <td><s:checkbox name="delFlag" fieldValue="%{id}"/></td>
    </tr>
    </s:iterator>
  </table>
  </s:if>
</div>

<div id="f_blank"></div>
<div id="f_line"></div>
<div id="f_exit"><a href="javascript:loginOut()" class="As"><s:text name="zongcheng.label.loginOut" /></a></div>
</s:form>
</body>

</html>