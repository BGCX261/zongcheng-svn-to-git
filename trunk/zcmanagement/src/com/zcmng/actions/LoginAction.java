package com.zcmng.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zcmng.commons.ValidationUtil;
import com.zcmng.forms.LoginForm;
import com.zcmng.models.Contact;
import com.zcmng.services.UserService;

/**
 * @author sunk
 *
 */
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements ModelDriven<LoginForm>
{
	private LoginForm loginForm = new LoginForm();
	private UserService userService;
	
	public void validateFindContact()
	{
		String loginId = this.loginForm.getLoginId();
		String loginPwd = this.loginForm.getLoginPwd();

		if (!ValidationUtil.validateRequired(loginId))
		{
			this.addFieldError("loginId", this.getText("zongcheng.error.required",
					new String[] { this.getText("zongcheng.label.loginId") }));
		}
		if (!ValidationUtil.validateRequired(loginPwd))
		{
			this.addFieldError("loginPwd", this.getText("zongcheng.error.required",
					new String[] { this.getText("zongcheng.label.loginPwd") }));
		}
	}
	
	/**
	 * login method
	 * 
	 * @return
	 * @throws Exception
	 */
	public String unspecified() throws Exception
	{
		return INPUT;
	}
	
	public String loginOut() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().clear();
		return INPUT;
	}
	
	
	/**
	 * login method
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findContact() throws Exception
	{
		String loginId = this.loginForm.getLoginId();
		String loginPwd = this.loginForm.getLoginPwd();

		Contact user = this.userService.findUserByIdAndPwd(loginId, loginPwd);
		if (user == null)
		{
			System.out.println("user is null");
			this.addActionError(this.getText("zongcheng.error.login.failed",
					new String[] { this.getText("zongcheng.label.loginId"),
							this.getText("zongcheng.label.loginPwd") }));

			return ERROR;
		} else
		{
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("currentUser", user);
			return SUCCESS;
		}
	}
	
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	public LoginForm getModel()
	{
		return loginForm;
	}	
}
