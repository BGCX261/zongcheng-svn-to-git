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
	document.contactListForm.action = "forwardUpdateContact.action?userId="+obj;
	document.contactListForm.submit();
}

function subDel()
{
	var delUserIds = "";
	var delFlag = document.getElementsByName("delFlag");
	for(var i=0; i<delFlag.length; i++)
	{
		if(delFlag[i].checked)
		{
			delUserIds += delFlag[i].value + ",";
		}
	}

	delUserIds = delUserIds.substring(0, delUserIds.length-1);
	if(confirm("Are you sure?"))
	{
		document.contactListForm.action = "deleteContact.action?delUserIds="+delUserIds;
		document.contactListForm.submit();			
	}

}

function loginOut()
{
	document.contactListForm.action = "loginOut.action";
	document.contactListForm.submit();	
}

function viewContacts(obj)
{
	document.contactListForm.action = "viewContacts.action?currentPage="+obj;
	document.contactListForm.submit();	
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
<s:fielderror/>
<s:actionerror/>

<s:form name="contactListForm">
<div id="main">
  <div class="block1">
    <div class="block_add">
	    <input type="button" name="addNewsBtn" 
	    	value="<s:property value="getText('zongcheng.button.addBtn')"/>" 
	    	onclick="javascript:forwardUpdate()"/>    
    </div>

	  <!-- For Pagination -->
	  <div class="block_index">
	  <s:if test="null != #userList && !#userList.isEmpty()">
	    <s:if test="#pagination.needShowFirstPage">
	    	<a href="javascript:viewContacts(1)"><s:text name="zongcheng.label.firstPage" /></a>
	    </s:if>
	  	<s:iterator value="#pagiForm.pageNumbers">
	  		<a href="javascript:viewContacts(<s:property/>)"><s:property/></a>
	  	</s:iterator>
	     <s:if test="#pagiForm.needShowLastPage">
	    	<a href="javascript:viewContacts(<s:property value="#pagiForm.getTotalPageCount"/>)"><s:text name="zongcheng.label.lastPage" /></a>
	    </s:if> 	
	  </s:if>
	  </div>
  	
  </div>
  <s:if test="null != #userList && !#userList.isEmpty()">
  <table border="0" cellspacing="0" cellpadding="0" class="listtb">
    <tr class="listtb_t">
      <td><s:text name="zongcheng.label.loginId" /></td>
      <td><s:text name="zongcheng.label.userName" /></td>
      <td><input type="button" name="delUserBtn" value="<s:property value="getText('zongcheng.button.deleteBtn')"/>" onclick="javascript:subDel()"/></td>      
    </tr>
    <s:iterator value="#userList" status="index">
    <tr <s:if test="#index.odd == true"> class="libg" </s:if> >
      <td><s:property value="loginId"/></td>
      <td><s:property value="userName"/></td>   
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