package com.zcmng.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zcmng.commons.Constants;
import com.zcmng.commons.ValidationUtil;
import com.zcmng.forms.PaginationForm;
import com.zcmng.forms.UserForm;
import com.zcmng.forms.UserMapper;
import com.zcmng.models.Contact;
import com.zcmng.services.UserService;

/**
 * @author sunk
 *
 */
@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<UserForm>
{
	private UserForm userForm = new UserForm();
	private UserService userService;
	
	public String unspecified() throws Exception
	{
		Map<String, Object> params = ActionContext.getContext().getParameters();
		PaginationForm pagiForm = new PaginationForm();
		if(params.get("currentPage") != null)
		{
			String currentPage = ((String[])params.get("currentPage"))[0];
			if(currentPage!= null && !Constants.EMPTY_STRING.equals(currentPage) && !Constants.UNDEFINE_STRING.equals(currentPage) )
			{
				pagiForm.setCurrentPage(Integer.parseInt(currentPage));
			}
		}
		Map<String, Object> pagiMap = new HashMap<String, Object>();
		pagiMap.put("pageStart", pagiForm.getPageStart());
		pagiMap.put("pageEnd", pagiForm.getPageEnd());
		
		List<Contact> userList = userService.findAllUsers(pagiMap);
		List<UserForm> formList = new ArrayList<UserForm>();
		UserMapper mapper = new UserMapper();
		for(Contact user : userList)
		{
			UserForm form = new UserForm();
			mapper.toUserForm(user, form);
			formList.add(form);
		}
		
		ActionContext ctx = ActionContext.getContext();
		ctx.put("userList", formList);
		
		pagiForm.setTotalCount(userService.getUsersCountByCondition());
		ctx.put("pagiForm", pagiForm);		
		return SUCCESS;
	}
	
	public String forwardUpdateUser() throws Exception
	{
		Map<String, Object> params = ActionContext.getContext().getParameters();
		if(params.get("userId") != null)
		{
			String userId = ((String[])params.get("userId"))[0];
			if(userId!= null && !Constants.EMPTY_STRING.equals(userId) && !Constants.UNDEFINE_STRING.equals(userId) )
			{
				Contact user = userService.findUserById(Integer.parseInt(userId));
				
				UserMapper mapper = new UserMapper();
				mapper.toUserForm(user, userForm);
			}			
		}
		
		return INPUT;
	}
	
	public String updateUser() throws Exception
	{
		UserMapper mapper = new UserMapper();
		Contact user = new Contact(); 
		mapper.toUserModel(userForm, user);
		
		userService.insertOrUpdateUser(user);
		
		return SUCCESS;
	}
	
	public String deleteUser() throws Exception
	{
		Map<String, Object> params = ActionContext.getContext().getParameters();
		String userIds = ((String[])params.get("delUserIds"))[0];
		
		userService.deleteUsers(userIds);
		
		return SUCCESS;
	}	
	
	/**
	 * Validation when insert/update an User
	 * 
	 * @throws Exception
	 */
	public void validateUpdateUser() throws Exception
	{
		validateLoginId();		
	    validateLoginPwd();
	    validateNickName();	
	    validateDuplicateLoginId();
	}	
	
	private void validateLoginId()
	{
		String loginId = userForm.getLoginId();		
		if (!ValidationUtil.validateRequired(loginId))
		{
			this.addFieldError("loginId", this.getText("zongcheng.error.required",
					new String[] { this.getText("zongcheng.label.loginId") }));
		} 
		else if (!ValidationUtil.validateMaxLength( loginId,Constants.MAX_DB_STRING_32))
		{
			this.addFieldError("loginId", this.getText("zongcheng.error.maxlength",
					new String[] { this.getText("zongcheng.label.loginId"), Constants.MAX_DB_STRING_32+"" }));			
		}		
	}
	
	private void validateLoginPwd()
	{
		String loginPwd = userForm.getLoginPwd();
		if (!ValidationUtil.validateRequired(loginPwd))
		{
			this.addFieldError("loginPwd", this.getText("zongcheng.error.required",
					new String[] { this.getText("zongcheng.label.loginPwd") }));
		} 
		else if (!ValidationUtil.validateMaxLength( loginPwd,Constants.MAX_DB_STRING_16))
		{
			this.addFieldError("loginPwd", this.getText("zongcheng.error.maxlength",
					new String[] { this.getText("zongcheng.label.loginPwd"), Constants.MAX_DB_STRING_16+"" }));			
		}
		
		String confirmPwd = userForm.getConfirmPwd();
		if (!ValidationUtil.validateRequired(confirmPwd))
		{
			this.addFieldError("confirmPwd", this.getText("zongcheng.error.required",
					new String[] { this.getText("zongcheng.label.confirmPwd") }));
		}
		else if (!ValidationUtil.validateEqualsForString(loginPwd, confirmPwd))
		{
			this.addFieldError("confirmPwd", this.getText("zongcheng.error.notEquals",
					new String[] { this.getText("zongcheng.label.loginPwd"), this.getText("zongcheng.label.confirmPwd") }));				
		}			
	}	
	
	private void validateNickName()
	{
		String userName = userForm.getUserName();
		if (!ValidationUtil.validateRequired(userName))
		{
			this.addFieldError("nickName", this.getText("zongcheng.error.required",
					new String[] { this.getText("zongcheng.label.userName") }));
		} 
		else if (!ValidationUtil.validateMaxLength( userName,Constants.MAX_DB_STRING_64))
		{
			this.addFieldError("nickName", this.getText("zongcheng.error.maxlength",
					new String[] { this.getText("zongcheng.label.userName"), Constants.MAX_DB_STRING_64+"" }));			
		}			
	}	
	
	private void validateDuplicateLoginId() throws Exception 
	{
		int loginIds = userService.getContactCountByLoginId(userForm.getLoginId());
		if (loginIds > 0) {
			this.addFieldError("loginId", this.getText(
					"zongcheng.error.duplicate", new String[] { this.getText("zongcheng.label.loginId") }));
		}
	}
	
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	public UserForm getModel()
	{
		return this.userForm;
	}		
}
