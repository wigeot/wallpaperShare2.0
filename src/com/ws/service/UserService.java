package com.ws.service;

import com.ws.domain.Sys_User;

public interface UserService {
	//��¼����
	Sys_User getUserByCodePassword(Sys_User sys_User);
	//ע���û�
	void saveUser(Sys_User u);

}
