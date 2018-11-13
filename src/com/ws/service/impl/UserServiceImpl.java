package com.ws.service.impl;

import com.ws.dao.UserDao;
import com.ws.domain.Sys_User;
import com.ws.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	

	//��¼����
	public Sys_User getUserByCodePassword(Sys_User sys_User) {
		//1.���ݵ�¼���Ʋ�ѯ�û�����existU�ǲ�ѯ�����û���sys_User�Ǵ��������û�����ע������ֱ�ӷ�����һ������������������룩
		Sys_User existU = userDao.getByUserCode(sys_User.getUser_userName());
		//2.�ж��û����Ƿ���ڣ������ڣ�ֱ���׳��쳣����ʾ�û���������
		if(existU == null){
			throw new RuntimeException("�û���������!");
		}
		//3.�ж��û������Ƿ���ȷ������ȷ��ֱ���׳��쳣����ʾ�������
		if(!existU.getUser_password().equals(sys_User.getUser_password())){
			throw new RuntimeException("�������!");
		}
		//4.���ز�ѯ�����û�����
		return existU;
	}
	
	//ע�᷽��
	public void saveUser(Sys_User sys_User) {

		//1 ����Dao����ע��ĵ�½������û�����
		System.out.println("1111122222222222222111");
		Sys_User existU = userDao.getByUserCode(sys_User.getUser_userName());
		System.out.println("1111111111111111111111");
		if(existU!=null){
		//2 �����õ�user����,�û����Ѿ�����,�׳��쳣
			throw new RuntimeException("�û����Ѿ�����2!");
		}
		
		/* ��
		//ʹ��MD5��������м���
		u.setUser_password(MD5Utils.md5(u.getUser_password()));*/
		
		//3 ����Daoִ�б���
		System.out.println("12222");
		userDao.save(sys_User);
		System.out.println("111");
	}

	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
