package com.ws.dao;

import com.ws.domain.Sys_User;

public interface UserDao  extends BaseDao<Sys_User>{
	//根据用户名查询用户的方法（返回一个完整的用户信息对象）
	Sys_User getByUserCode(String user_code);
	//注册方法
	void save(Sys_User sys_User);

}
