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
	document.customerForm.action = "updateCustomer.action";
	document.customerForm.submit();
}

function viewCustomer()
{
	document.customerForm.action = "viewCustomers.action";
	document.customerForm.submit();
}

function loginOut()
{
	document.customerForm.action = "loginOut.action";
	document.customerForm.submit();	
}

function viewCustomerContacts(obj)
{
	document.companyListForm.action = "viewCustomerContacts.action?customerId="+obj;
	document.companyListForm.submit();
}

function viewCustomerProjects(obj)
{
	document.companyListForm.action = "viewCustomerProjects.action?customerId="+obj;
	document.companyListForm.submit();
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

<s:form name="customerForm">
<s:hidden name="id"/>
<div id="main">
  <div class="block1">
    <div class="block_text"><a href="javascript:viewCustomer()">&lt;&lt; <s:text name="zongcheng.label.customerList" /></a></div>
  </div>
  <table border="0" cellspacing="0" cellpadding="0" class="detail_tb">
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.customerName"/></td>
      <td><s:textfield name="companyName"/><span class="c_red">*</span></td>
    </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.attribute"/></td>
      <td><s:textfield name="attribute"/></td>
    </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.region"/></td>
      <td><s:textfield name="region"/></td>
    </tr>        
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.field"/></td>
      <td><s:textfield name="field"/></td>
    </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.major"/></td>
      <td><s:textfield name="major"/></td>
    </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.address"/></td>
      <td><s:textfield name="address"/></td>
    </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.url"/></td>
      <td><s:textfield name="url"/></td>
    </tr>   
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.orderCount"/></td>
      <td><s:textfield name="orderCount"/></td>
    </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.orderMoney"/></td>
      <td><s:textfield name="orderMoney"/></td>
    </tr>        
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.paymentWay"/></td>
      <td><s:textfield name="paymentWay"/></td>
    </tr>
    <tr>
      <td class="c_title"><s:text name="zongcheng.label.creditLevel"/></td>
      <td><s:textfield name="creditLevel"/></td>
    </tr>
    <s:if test="null != <s:property value='id'/> && 0 != <s:property value='id'/>">
	    <tr>
	      <td class="c_title"><s:text name="zongcheng.label.viewCustomerContacts" /></td>
	      <td><a href="javascript:viewCustomerContacts(<s:property value="id"/>)"><s:property value="customerContactSize" /></a></td>
	    </tr>
	    <tr>
	      <td class="c_title"><s:text name="zongcheng.label.viewCustomerProjects" /></td>
	      <td><a href="javascript:viewCustomerProjects(<s:property value="id"/>)"><s:property value="customerProjectSize" /></a></td>
	    </tr> 
    </s:if>  
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