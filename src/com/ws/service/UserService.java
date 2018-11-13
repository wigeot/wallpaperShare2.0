package com.ws.service;

import com.ws.domain.Sys_User;

public interface UserService {
	//登录方法
	Sys_User getUserByCodePassword(Sys_User sys_User);
	//注册用户
	void saveUser(Sys_User u);

}
