<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="pramga" content="no-cache" />
<meta http-equiv="expires" content="0" />
<title>Welcome To ZongCheng</title>
<link href="./css/login.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
function subLogin()
{
	document.loginForm.submit()
}
</script>
</head>

<body>
<div id="panel">
<!-- error -->
<s:fielderror/>
<s:actionerror/>

<s:form name="loginForm" action="login">
<table border="0" cellspacing="0" cellpadding="0" id="p_input">
  <tr>
    <td class="input_t"><s:text name="zongcheng.label.loginId"/></td>
    <td class="input_c"><s:textfield name="loginId"/></td>
  </tr>
  <tr>
    <td class="input_t"><s:text name="zongcheng.label.loginPwd" /></td>
    <td class="input_c"><s:password name="loginPwd"/></td>
  </tr>
</table>
<div id="p_bt">
	<s:submit type="button" name="confirmBtn" key="zongcheng.button.confirmBtn" 
		onclick="javascript:subLogin()" />
</div>
</s:form>

</div>
</body>
</html>