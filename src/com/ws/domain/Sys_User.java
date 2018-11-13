package com.ws.domain;


/**
 * �û���
 * 
 * CREATE TABLE `login` (
  `login_id` varchar(50) NOT NULL COMMENT 'Ψһid�������ظ����Զ����ɣ�',
  `login_userName` varchar(50) NOT NULL COMMENT '�û��������ظ�)',
  `login_password` varchar(50) NOT NULL COMMENT '����',
  `login_email` varchar(50) NOT NULL COMMENT '�û����䣬����',
  `login_phone` varchar(50) NOT NULL COMMENT '�û��绰�����',
  `login_sex` varchar(50) DEFAULT NULL COMMENT '�Ա�',
  `login_province` varchar(50) DEFAULT NULL COMMENT 'ʡ��',
  `login_city` varchar(50) DEFAULT NULL COMMENT '��',
  	login_area									������
  `login_code` varchar(50) DEFAULT NULL COMMENT '������',
  `login_state` int(5) DEFAULT NULL COMMENT '״̬',
  PRIMARY KEY (`login_id`)
)
 *
 */
public class Sys_User {
	
	private Integer user_id;	       //Ψһid(�ǿ�)
	private String user_userName;      //�û���
	private String user_password;      //����
	private String user_email;         //�û�����
	private String user_phone;         //�û��绰
	private String user_sex;           //�Ա�	
	private String user_province;      //ʡ��
	private String user_city;          //��
	private String user_area;		   //��
	private String user_code;          //������
	private String user_state;         //״̬
	
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_userName() {
		return user_userName;
	}
	public void setUser_userName(String user_userName) {
		this.user_userName = user_userName;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_province() {
		return user_province;
	}
	public void setUser_province(String user_province) {
		this.user_province = user_province;
	}
	public String getUser_city() {
		return user_city;
	}
	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getUser_state() {
		return user_state;
	}
	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}
	public String getUser_area() {
		return user_area;
	}
	public void setUser_area(String user_area) {
		this.user_area = user_area;
	}
	
	
	
}
