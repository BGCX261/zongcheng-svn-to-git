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
	var actionPath = "forwardUpdateCustomerProject.action?customerId="+obj1;
	if(obj2 != null)
	{
		actionPath += "&customerProjectId="+obj2
	}

	window.open(actionPath, 'UpdateCustomerProject', 'height=800, width=600, top=200, left=400, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, status=no');
}

function subDel()
{
	var customerProjectIds = "";
	var delFlag = document.getElementsByName("delFlag");

	for(var i=0; i<delFlag.length; i++)
	{
		if(delFlag[i].checked)
		{
			customerProjectIds += delFlag[i].value + ",";
		}
	}
	customerProjectIds = customerProjectIds.substring(0, customerProjectIds.length-1);

	if(confirm("Are you sure?"))
	{
		document.customerProjectListForm.action = "deleteCustomerProject.action?delCustomerProjectIds="+customerProjectIds;
		document.customerProjectListForm.submit();	
		window.refresh();
	}

}

function loginOut()
{
	document.customerProjectListForm.action = "loginOut.action";
	document.customerProjectListForm.submit();	
}

function viewCustomers()
{
	document.customerProjectListForm.action = "viewCustomers.action";
	document.customerProjectListForm.submit();	
}

function refresh()
{
	var customerId = document.getElementById("customerId").value;
	document.customerProjectListForm.action = "viewCustomerProjects.action?customerId="+customerId;
	document.customerProjectListForm.submit();	
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
<s:form name="customerProjectListForm">
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
  <s:if test="null != #customerProjectList && !#customerProjectList.isEmpty()">
  <table border="0" cellspacing="0" cellpadding="0" class="listtb">
    <tr class="listtb_t">
      <td><s:text name="zongcheng.label.projectRequirement" /></td>
      <td><s:text name="zongcheng.label.productRequirement" /></td>
      <td><s:text name="zongcheng.label.price" /></td>
      <td><s:text name="zongcheng.label.competition" /></td>
      <td><s:text name="zongcheng.label.competitionPrice" /></td>
      <td><s:text name="zongcheng.label.communicationDate" /></td>
      <td><s:text name="zongcheng.label.communicationNotes" /></td>    
      <td><input type="button" name="delUserBtn" value="<s:property value="getText('zongcheng.button.deleteBtn')"/>" onclick="javascript:subDel()"/></td>      
    </tr>
    <s:iterator value="#customerProjectList" status="index">
    <tr <s:if test="#index.odd == true"> class="libg" </s:if> >
      <td><s:property value="projectRequirement" /></td>
      <td><s:property value="productRequirement" /></td>
      <td><s:property value="price" /></td>
      <td><s:property value="competition" /></td>
      <td><s:property value="competitionPrice" /></td>
      <td><s:property value="communicationDate" /></td>
      <td><s:property value="communicationNotes" /></td> 
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