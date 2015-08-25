<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Welcome To ZongCheng</title>
<link href="./css/common.css" rel="stylesheet" type="text/css">

<link href="js/calendar/css/jscal2.css" rel="stylesheet" type="text/css">
<link href="js/calendar/css/border-radius.css" rel="stylesheet" type="text/css">
<link href="js/calendar/css/gold/gold.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="js/calendar/js/jscal2.js"></script>
<script type="text/javascript" src="js/calendar/js/lang/en.js"></script>
<script type="text/javascript">
function subForm()
{
	document.customerProjectForm.action = "updateCustomerProject.action";
	document.customerProjectForm.submit();
}

function loginOut()
{
	document.customerProjectForm.action = "loginOut.action";
	document.customerProjectForm.submit();	
}
</script>
</head>

<body>
<div id="menu">
  <div id="menu_box">
  <a href="#" class="m_on"><s:text name="zongcheng.label.customerManagement" /></a>
  </div>
</div>

<!-- error -->
<s:actionerror/>
<s:fielderror/>

<s:form name="customerProjectForm">
<s:hidden name="id"/>
<s:hidden name="customerId"/>
<div id="main">
  <table border="0" cellspacing="0" cellpadding="0" class="detail_tb">
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.projectRequirement"/></td>
      <td><textarea name="projectRequirement" cols="100" rows="12"><s:property value="projectRequirement"/></textarea></td>
    </tr>        
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.productRequirement"/></td>
      <td><textarea name="productRequirement" cols="100" rows="12"><s:property value="productRequirement"/></textarea></td>
    </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.price"/></td>
      <td><s:textfield name="price"/></td>
    </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.competition"/></td>
      <td><s:textfield name="competition"/></td>
    </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.competitionPrice"/></td>
      <td><s:textfield name="competitionPrice"/></td>
    </tr>        
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.communicationDate"/></td>
      <td>
      	  <s:textfield id="calendar-inputField" name="communicationDate" readOnly="true"/><button id="calendar-trigger"><s:text name='zongcheng.button.ellipsesBtn' /></button>	
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
      <td class="c_title"><s:text name="zongcheng.label.communicationNotes"/></td>
      <td><textarea name="communicationNotes" cols="100" rows="12"><s:property value="communicationNotes"/></textarea></td>
    </tr>      
    <tr>
      <td>&nbsp;</td>
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