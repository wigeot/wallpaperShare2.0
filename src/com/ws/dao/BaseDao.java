package com.ws.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
public interface BaseDao<T> {
	//�����޸�
	void saveOrUpdate(T t);
	//��
	void save(T t);
	//ɾ
	void delete(T t);
	//ɾ
	void delete(Serializable id);
	//��
	void update(T t);
	//�� ����id��ѯ
	T	getById(Serializable id);
	//�� �����������ܼ�¼��
	Integer	getTotalCount(DetachedCriteria dc);
	//�� ��ѯ��ҳ�б�����
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
	
}
