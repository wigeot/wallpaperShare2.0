package com.ws.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ws.dao.BaseDao;


/**
 	ʵ����BaseDao�ӿڡ�
 		������ķ�������ͨ�÷����� һ���ѯ���ݿ�ķ���������Ҫ��д��
 
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class clazz;//���ڽ��������ڷ�������
	//���췽�������ڻ�÷���ֵ
	public BaseDaoImpl() {
		//��õ�ǰ���͵Ĵ��з������͵ĸ���
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//��������ڵķ�������
		clazz = (Class) ptClass.getActualTypeArguments()[0];
	}
	//��
	public void save(T t) {
		getHibernateTemplate().save(t);
	}
	//�����޸�
	public void saveOrUpdate(T t) {
		//����������Զ��жϴ������Ĳ���������������Ĳ�����Ψһid����ô�����ж������޸ķ�������ʱ���Ǹ�������һ��������������id����
		//�����ж��Ƿ�Ϊ�޸ģ�
		//		�ж��Ƿ�Ϊ����״̬�����ж��Ƿ�Ϊ����Ҫִ�и��²�����˲ʱ״̬������Ҫ����������
		//		˲ʱ״̬������״̬�������Ƿ���Ψһid
		getHibernateTemplate().saveOrUpdate(t);
	}
	//ɾ
	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}
	//ɾ������idɾ����
	public void delete(Serializable id) {
		T t = this.getById(id);//��ȡ,��ɾ
		getHibernateTemplate().delete(t);
	}
	//��
	public void update(T t) {
		getHibernateTemplate().update(t);
	}
	//�� ������id��ѯ��
	public T getById(Serializable id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}
	//�� �������������ܼ�¼����
	public Integer getTotalCount(DetachedCriteria dc) {
		//���ò�ѯ�ľۺϺ���,�ܼ�¼������װ������
		dc.setProjection(Projections.rowCount());
		//��ѯ�ܼ�¼��������ȡ����ֵ
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		//���֮ǰ���õľۺϺ���
		dc.setProjection(null);
		
		if(list!=null && list.size()>0){
			Long count = list.get(0);
			return count.intValue();//ת����integer����
		}else{
			return null;
		}
	}
	//�飨 ��ѯ��ҳ�б����ݣ�
	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		//ע�������ѯ�Ƿ�ҳ��ѯ
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
		
		return list;
	}
	


}

