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
	private String checkcode;//ǰ̨�ύ����֤��
	

	//��¼
	public String login() throws Exception {
		 //1���ж���֤���Ƿ���ȷ
		 //��Session�л����֤������ֵ(��CheckImgAction�������Ѿ������ɵ���֤��ŵ���session��ȥ��)
		 String checkcode1 =(String)ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		 if(!checkcode.equalsIgnoreCase(checkcode1)){//����Ƚ��ǲ����Ǵ�Сд�ıȽ�
			 	/**		addActionError()
			 	 * 		��ֱ����ҳ��ʹ��<s:actionerror/>����ȡ������Ϣ
			 	 */
				this.addActionError("��֤���������!");
				return "error";
			}
		//2������serviceִ�е�¼�߼�
		Sys_User u = userService.getUserByCodePassword(sys_User);
		//3�������ص�user�������session��
		ActionContext.getContext().getSession().put("sys_User", u);
		//4���ض�����Ŀ��ҳ
		return "toHome";
	}
	//�˳��û�����
	public String userExit() throws Exception {
		//1.���cookie�д洢��ֵ
		Cookie cookie_username = new Cookie("cookie_username"," ");
		Cookie cookie_password = new Cookie("cookie_password"," "); 
		cookie_username.setMaxAge(0);
		cookie_password.setMaxAge(0);
		cookie_username.setPath(ServletActionContext.getRequest().getContextPath());
		cookie_password.setPath(ServletActionContext.getRequest().getContextPath());
		ServletActionContext.getResponse().addCookie(cookie_username);
		ServletActionContext.getResponse().addCookie(cookie_password);
		
		//2���Session
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("sys_User", null);
		return "toHome";
		
	}
	
	//ע�᷽��
	public String regist() throws Exception {
		 //1���ж���֤���Ƿ���ȷ
		 //��Session�л����֤������ֵ(��CheckImgAction�������Ѿ������ɵ���֤��ŵ���session��ȥ��)
/*		 String checkcode1 =(String)ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		 if(!checkcode.equalsIgnoreCase(checkcode1)){//����Ƚ��ǲ����Ǵ�Сд�ıȽ�
			 	*//**		addActionError()
			 	 * 		��ֱ����ҳ��ʹ��<s:actionerror/>����ȡ������Ϣ
			 	 *//*
				this.addActionError("��֤���������!");
				return "error";
			}*/
		 
		//1 ����Service����ע���û�
		try {
			userService.saveUser(sys_User);
		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * ���ﴦ���������治ͬ��
			 * 			login����ʹ�á�throw new RuntimeException("�û���������!");����strtus.xml��ʹ�á�<global-exception-mappings>��
			 * 		��ǩ�������쳣��������ʹ��tryҲ������strtus.xml�д����쳣
			 */
			ActionContext.getContext().put("error", e.getMessage());//���쳣�ŵ�action�У�ʹ��error����ȡ���쳣��Ϣ��
			return "regist";
		}
		//2 �ض��򵽵�½ҳ��
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
