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
	document.companyListForm.action = "forwardUpdateCustomer.action?customerId="+obj;
	document.companyListForm.submit();
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

function subDel()
{
	var customerIds = "";
	var delFlag = document.getElementsByName("delFlag");

	for(var i=0; i<delFlag.length; i++)
	{
		if(delFlag[i].checked)
		{
			customerIds += delFlag[i].value + ",";
		}
	}
	customerIds = customerIds.substring(0, customerIds.length-1);

	if(confirm("Are you sure?"))
	{
		document.companyListForm.action = "deleteCustomer.action?delCustomerIds="+customerIds;
		document.companyListForm.submit();			
	}

}

function loginOut()
{
	document.companyListForm.action = "loginOut.action";
	document.companyListForm.submit();	
}

function forwardReportsUpdate()
{
	document.companyListForm.action = "viewDailyReports.action";
	document.companyListForm.submit();	
}

function viewCustomers(obj)
{
	document.companyListForm.action = "viewCustomers.action?currentPage="+obj;
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

<s:form name="companyListForm">
<div id="main">
  <div class="block1">
    <div class="block_add">
	    <input type="button" name="addNewsBtn" 
	    	value="<s:property value="getText('zongcheng.button.addBtn')"/>" 
	    	onclick="javascript:forwardUpdate()"/>    
    </div>
    <div class="block_add">
	    <input type="button" name="viewReportsBtn" 
	    	value="<s:property value="getText('zongcheng.button.viewReportsBtn')"/>" 
	    	onclick="javascript:forwardReportsUpdate()"/>    
    </div>   
     
	 <!-- For Pagination -->
	 <div class="block_index">
	 <s:if test="null != #customerList && !#customerList.isEmpty()">
	   <s:if test="#pagination.needShowFirstPage">
	   	<a href="javascript:viewCustomers(1)"><s:text name="zongcheng.label.firstPage" /></a>
	   </s:if>
	 	<s:iterator value="#pagiForm.pageNumbers">
	 		<a href="javascript:viewCustomers(<s:property/>)"><s:property/></a>
	 	</s:iterator>
	    <s:if test="#pagiForm.needShowLastPage">
	   	<a href="javascript:viewCustomers(<s:property value="#pagiForm.getTotalPageCount"/>)"><s:text name="zongcheng.label.lastPage" /></a>
	   </s:if> 	
	 </s:if>
	 </div>  
  
  </div>
  <s:if test="null != #customerList && !#customerList.isEmpty()">
  <table border="0" cellspacing="0" cellpadding="0" class="listtb">
    <tr class="listtb_t">
      <td><s:text name="zongcheng.label.companyName" /></td>
      <td><s:text name="zongcheng.label.attribute" /></td>
      <td><s:text name="zongcheng.label.region" /></td>
      <td><s:text name="zongcheng.label.field" /></td>
      <td><s:text name="zongcheng.label.major" /></td>
      <td><s:text name="zongcheng.label.address" /></td>
      <td><s:text name="zongcheng.label.url" /></td>
      <td><s:text name="zongcheng.label.orderCount" /></td>
      <td><s:text name="zongcheng.label.orderMoney" /></td>
      <td><s:text name="zongcheng.label.paymentWay" /></td>
	  <td><s:text name="zongcheng.label.creditLevel" /></td>    
	  <td><s:text name="zongcheng.label.viewCustomerContacts" /></td> 
	  <td><s:text name="zongcheng.label.viewCustomerProjects" /></td>  
	  <td><s:text name="zongcheng.label.userName" /></td> 
	  <td></td> 
      <td><input type="button" name="delUserBtn" value="<s:property value="getText('zongcheng.button.deleteBtn')"/>" onclick="javascript:subDel()"/></td>      
    </tr>
    <s:iterator value="#customerList" status="index">
    <tr <s:if test="#index.odd == true"> class="libg" </s:if> >
      <td><s:property value="companyName"/></td>  
      <td><s:property value="attribute" /></td>
      <td><s:property value="region" /></td>
      <td><s:property value="field" /></td>
      <td><s:property value="major" /></td>
      <td><s:property value="address" /></td>
      <td><s:property value="url" /></td>
      <td><s:property value="orderCount" /></td>
      <td><s:property value="orderMoney" /></td>
      <td><s:property value="paymentWay" /></td>
	  <td><s:property value="creditLevel" /></td>    
	  <td class="lic_A"><a href="javascript:viewCustomerContacts(<s:property value="id"/>)"><s:property value="customerContactSize" /></a></td> 
	  <td class="lic_A"><a href="javascript:viewCustomerProjects(<s:property value="id"/>)"><s:property value="customerProjectSize" /></a></td> 
	  <td><s:property value="ownerName" /></td>   
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