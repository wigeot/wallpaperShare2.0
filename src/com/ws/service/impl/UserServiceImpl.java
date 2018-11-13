package com.ws.service.impl;

import com.ws.dao.UserDao;
import com.ws.domain.Sys_User;
import com.ws.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	

	//登录方法
	public Sys_User getUserByCodePassword(Sys_User sys_User) {
		//1.根据登录名称查询用户名（existU是查询到的用户，sys_User是传进来的用户）（注：这里直接返回了一个对象，里面包含了密码）
		Sys_User existU = userDao.getByUserCode(sys_User.getUser_userName());
		//2.判断用户名是否存在，不存在，直接抛出异常，提示用户名不存在
		if(existU == null){
			throw new RuntimeException("用户名不存在!");
		}
		//3.判断用户密码是否正确，不正确，直接抛出异常，提示密码错误
		if(!existU.getUser_password().equals(sys_User.getUser_password())){
			throw new RuntimeException("密码错误!");
		}
		//4.返回查询到的用户对象
		return existU;
	}
	
	//注册方法
	public void saveUser(Sys_User sys_User) {

		//1 调用Dao根据注册的登陆名获得用户对象
		System.out.println("1111122222222222222111");
		Sys_User existU = userDao.getByUserCode(sys_User.getUser_userName());
		System.out.println("1111111111111111111111");
		if(existU!=null){
		//2 如果获得到user对象,用户名已经存在,抛出异常
			throw new RuntimeException("用户名已经存在2!");
		}
		
		/* ·
		//使用MD5对密码进行加密
		u.setUser_password(MD5Utils.md5(u.getUser_password()));*/
		
		//3 调用Dao执行保存
		System.out.println("12222");
		userDao.save(sys_User);
		System.out.println("111");
	}

	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
