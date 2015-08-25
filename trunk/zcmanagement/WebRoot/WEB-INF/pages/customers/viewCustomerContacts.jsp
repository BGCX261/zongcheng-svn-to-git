<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Welcome To ZongCheng</title>
<link href="./css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function forwardUpdate(obj1, obj2)
{
	var actionPath = "forwardUpdateCustomerContact.action?customerId="+obj1;
	if(obj2 != null)
	{
		actionPath += "&customerContactId="+obj2;
	}

	window.open(actionPath, 'UpdateCustomerContact', 'height=400, width=400, top=200, left=400, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');
	
}

function subDel()
{
	var customerContactIds = "";
	var delFlag = document.getElementsByName("delFlag");

	for(var i=0; i<delFlag.length; i++)
	{
		if(delFlag[i].checked)
		{
			customerContactIds += delFlag[i].value + ",";
		}
	}
	customerContactIds = customerContactIds.substring(0, customerContactIds.length-1);

	if(confirm("Are you sure?"))
	{
		document.customerContactListForm.action = "deleteCustomerContact.action?delCustomerContactIds="+customerContactIds;
		document.customerContactListForm.submit();	
		window.refresh();		
	}

}

function loginOut()
{
	document.customerContactListForm.action = "loginOut.action";
	document.customerContactListForm.submit();	
}

function viewCustomers()
{
	document.customerContactListForm.action = "viewCustomers.action";
	document.customerContactListForm.submit();	
}

function refresh()
{
	var customerId = document.getElementById("customerId").value;
	document.customerContactListForm.action = "viewCustomerContacts.action?customerId="+customerId;
	document.customerContactListForm.submit();
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

<s:hidden id="customerId" name="customerId"/>
<s:form name="customerContactListForm">
<div id="main">
  <div class="block1">
    <div class="block_add">
	    <input type="button" name="addNewsBtn" 
	    	value="<s:property value="getText('zongcheng.button.addBtn')"/>" 
	    	onclick="javascript:forwardUpdate(<s:property value="customerId"/>)"/>    
    </div>
    <div class="block_add">
	    <input type="button" name="viewCustomersBtn" 
	    	value="<s:property value="getText('zongcheng.button.viewCustomersBtn')"/>" 
	    	onclick="javascript:viewCustomers()"/>    
    </div>  
  </div>
  <s:if test="null != #customerContactList && !#customerContactList.isEmpty()">
  <table border="0" cellspacing="0" cellpadding="0" class="listtb">
    <tr class="listtb_t">
      <td><s:text name="zongcheng.label.contact" /></td>
      <td><s:text name="zongcheng.label.position" /></td>
      <td><s:text name="zongcheng.label.telephone" /></td>
      <td><s:text name="zongcheng.label.fax" /></td>
      <td><s:text name="zongcheng.label.mobile" /></td>
      <td><s:text name="zongcheng.label.email" /></td>
      <td><s:text name="zongcheng.label.purchaseRole" /></td>    
      <td><input type="button" name="delUserBtn" value="<s:property value="getText('zongcheng.button.deleteBtn')"/>" onclick="javascript:subDel()"/></td>      
    </tr>
    <s:iterator value="#customerContactList" status="index">
    <tr <s:if test="#index.odd == true"> class="libg" </s:if> >
      <td><s:property value="contact" /></td>
      <td><s:property value="position" /></td>
      <td><s:property value="telephone" /></td>
      <td><s:property value="fax" /></td>
      <td><s:property value="mobile" /></td>
      <td><s:property value="email" /></td>
      <td><s:property value="purchaseRole" /></td>   
      <td class="lic_A"><a href="javascript:forwardUpdate(<s:property value="customerId"/>,<s:property value="id"/>)"><s:text name="zongcheng.label.modify" /></a></td>
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