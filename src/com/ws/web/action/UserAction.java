package com.ws.web.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ws.domain.Sys_User;
import com.ws.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<Sys_User>{
	private Sys_User sys_User = new Sys_User();
	
	private UserService userService;
	private String checkcode;//前台提交的验证码
	

	//登录
	public String login() throws Exception {
		 //1、判断验证码是否正确
		 //从Session中获得验证码的随机值(在CheckImgAction中我们已经把生成的验证码放到了session中去了)
		 String checkcode1 =(String)ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		 if(!checkcode.equalsIgnoreCase(checkcode1)){//这个比较是不考虑大小写的比较
			 	/**		addActionError()
			 	 * 		可直接在页面使用<s:actionerror/>来获取错误信息
			 	 */
				this.addActionError("验证码输入错误!");
				return "error";
			}
		//2、调用service执行登录逻辑
		Sys_User u = userService.getUserByCodePassword(sys_User);
		//3、将返回的user对象放入session域
		ActionContext.getContext().getSession().put("sys_User", u);
		//4、重定向到项目首页
		return "toHome";
	}
	//退出用户方法
	public String userExit() throws Exception {
		//1.清空cookie中存储的值
		Cookie cookie_username = new Cookie("cookie_username"," ");
		Cookie cookie_password = new Cookie("cookie_password"," "); 
		cookie_username.setMaxAge(0);
		cookie_password.setMaxAge(0);
		cookie_username.setPath(ServletActionContext.getRequest().getContextPath());
		cookie_password.setPath(ServletActionContext.getRequest().getContextPath());
		ServletActionContext.getResponse().addCookie(cookie_username);
		ServletActionContext.getResponse().addCookie(cookie_password);
		
		//2清空Session
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("sys_User", null);
		return "toHome";
		
	}
	
	//注册方法
	public String regist() throws Exception {
		 //1、判断验证码是否正确
		 //从Session中获得验证码的随机值(在CheckImgAction中我们已经把生成的验证码放到了session中去了)
/*		 String checkcode1 =(String)ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		 if(!checkcode.equalsIgnoreCase(checkcode1)){//这个比较是不考虑大小写的比较
			 	*//**		addActionError()
			 	 * 		可直接在页面使用<s:actionerror/>来获取错误信息
			 	 *//*
				this.addActionError("验证码输入错误!");
				return "error";
			}*/
		 
		//1 调用Service保存注册用户
		try {
			userService.saveUser(sys_User);
		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * 这里处理方法和上面不同：
			 * 			login（）使用“throw new RuntimeException("用户名不存在!");”在strtus.xml中使用“<global-exception-mappings>”
			 * 		标签来处理异常，而这里使用try也可以在strtus.xml中处理异常
			 */
			ActionContext.getContext().put("error", e.getMessage());//把异常放到action中（使用error可以取出异常信息）
			return "regist";
		}
		//2 重定向到登陆页面
	return "toHome2";
	}
	
	
	
	
	
	

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Sys_User getModel() {
		return sys_User;
	}

}
