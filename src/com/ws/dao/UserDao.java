package com.ws.dao;

import com.ws.domain.Sys_User;

public interface UserDao  extends BaseDao<Sys_User>{
	//�����û�����ѯ�û��ķ���������һ���������û���Ϣ����
	Sys_User getByUserCode(String user_code);
	//ע�᷽��
	void save(Sys_User sys_User);

}
