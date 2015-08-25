<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Welcome To ZongCheng</title>
<link href="./css/common.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
function subForm()
{
	document.customerContactForm.action = "updateCustomerContact.action";
	document.customerContactForm.submit();
}

function loginOut()
{
	document.customerContactForm.action = "loginOut.action";
	document.customerContactForm.submit();	
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

<s:form name="customerContactForm">
<s:hidden name="id"/>
<s:hidden name="customerId"/>
<div id="main">
  <table border="0" cellspacing="0" cellpadding="0" class="detail_tb">     
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.contact"/></td>
      <td><s:textfield name="contact"/></td>
    </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.position"/></td>
      <td><s:textfield name="position"/></td>
    </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.telephone"/></td>
      <td><s:textfield name="telephone"/></td>
    </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.fax"/></td>
      <td><s:textfield name="fax"/></td>
    </tr>        
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.mobile"/></td>
      <td><s:textfield name="mobile"/></td>
    </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.email"/></td>
      <td><s:textfield name="email"/></td>
    </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.purchaseRole"/></td>
      <td><s:textfield name="purchaseRole"/></td>
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