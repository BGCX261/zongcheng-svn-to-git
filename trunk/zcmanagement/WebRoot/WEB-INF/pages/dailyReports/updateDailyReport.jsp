<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Welcome To ZongCheng</title>
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="js/calendar/css/jscal2.css" rel="stylesheet" type="text/css">
<link href="js/calendar/css/border-radius.css" rel="stylesheet" type="text/css">
<link href="js/calendar/css/gold/gold.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="js/calendar/js/jscal2.js"></script>
<script type="text/javascript" src="js/calendar/js/lang/en.js"></script>

<script type="text/javascript">
function subForm()
{
	document.dailyReportForm.action = "updateDailyReport.action";
	document.dailyReportForm.submit();
}

function viewReport()
{
	document.dailyReportForm.action = "viewDailyReports.action";
	document.dailyReportForm.submit();
}

function loginOut()
{
	document.dailyReportForm.action = "loginOut.action";
	document.dailyReportForm.submit();	
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

<s:form name="dailyReportForm">
<div id="main">

<s:hidden name="id"/>
  <div class="block1">
    <div class="block_text"><a href="javascript:viewReport()">&lt;&lt; <s:text name="zongcheng.label.reportList" /></a></div>
  </div>
  <table border="0" cellspacing="0" cellpadding="0" class="detail_tb">
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.publishDate" /><span class="c_red">*</span></td>
      <td>
      	  <s:textfield id="calendar-inputField" name="publishDate" readOnly="true"/><button id="calendar-trigger"><s:text name='zongcheng.button.ellipsesBtn' /></button>	
		  
			<script type="text/javascript">			
			       Calendar.setup({
			           inputField: "calendar-inputField",
			           trigger: "calendar-trigger",
			           weekNumbers: true,
			           showTime: false,
			           onSelect: function() {this.hide();}
			       });
			
			</script>
      </td>
    </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.customerName" /><span class="c_red">*</span></td>
      <td>  	  
         <s:select name="customerId" list="#customerList" listKey="id" listValue="companyName"></s:select>
         <span class="c_red">*</span>
     </td>
   </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.task" /><span class="c_red">*</span></td>
      <td><textarea name="task" cols="100" rows="6"><s:property value="task"/></textarea></td>
    </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.notes" /></td>
      <td><textarea name="notes" cols="100" rows="12"><s:property value="notes"/></textarea></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>
	    <div class="confirm_c"><input type="button" name="confirmBtn"
  	  	  value="<s:property value="getText('zongcheng.button.confirmBtn')"/>" 
  	  	  onclick="javascript:subForm()"/></div>
	  </td>
    </tr>
  </table>

</div>
<div id="f_blank"></div>
<div id="f_line"></div>
<div id="f_exit"><a href="javascript:loginOut()" class="As"><s:text name="zongcheng.label.loginOut" /></a></div>
</s:form>
</body>
</html>
