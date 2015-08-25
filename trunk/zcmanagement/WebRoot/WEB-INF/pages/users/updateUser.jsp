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
	document.contactForm.action = "updateContact.action";
	document.contactForm.submit();
}

function viewContacts()
{
	document.contactForm.action = "viewContacts.action";
	document.contactForm.submit();
}

function loginOut()
{
	document.contactForm.action = "loginOut.action";
	document.contactForm.submit();	
}
</script>
</head>

<body>
<div id="menu">
  <div id="menu_box">
  <a href="#" class="m_on"><s:text name="zongcheng.label.contactManagement" /></a>
  </div>
</div>

<!-- error -->
<s:actionerror/>
<s:fielderror/>

<s:form name="contactForm">
<s:hidden name="id"/>
<div id="main">
  <div class="block1">
    <div class="block_text"><a href="javascript:viewContacts()">&lt;&lt; <s:text name="zongcheng.label.contactList" /></a></div>
  </div>
  <table border="0" cellspacing="0" cellpadding="0" class="detail_tb">
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.loginId"/></td>
      <td><s:textfield name="loginId"/><span class="c_red">*</span></td>
    </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.userName"/></td>
      <td><s:textfield name="userName"/><span class="c_red">*</span></td>
    </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.loginPwd"/></td>
      <td><s:password name="loginPwd"/><span class="c_red">*</span></td>
    </tr>    
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.confirmPwd"/></td>
      <td><s:password name="confirmPwd"/><span class="c_red">*</span></td>
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