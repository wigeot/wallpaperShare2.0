package com.ws.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ws.dao.BaseDao;


/**
 	实现了BaseDao接口。
 		这里面的方法都是通用方法， 一般查询数据库的方法都不需要重写了
 
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class clazz;//用于接收运行期泛型类型
	//构造方法，用于获得泛型值
	public BaseDaoImpl() {
		//获得当前类型的带有泛型类型的父类
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得运行期的泛型类型
		clazz = (Class) ptClass.getActualTypeArguments()[0];
	}
	//增
	public void save(T t) {
		getHibernateTemplate().save(t);
	}
	//增或修改
	public void saveOrUpdate(T t) {
		//这个方法会自动判断传进来的参数，如果传进来的参数有唯一id，那么就能判断这是修改方法，这时我们给她传进一个对象，它里面有id就行
		//关于判断是否为修改：
		//		判断是否为游离状态就能判断是否为是需要执行更新操作，瞬时状态就是需要操作方法增
		//		瞬时状态与游离状态差别就在是否有唯一id
		getHibernateTemplate().saveOrUpdate(t);
	}
	//删
	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}
	//删（根据id删除）
	public void delete(Serializable id) {
		T t = this.getById(id);//先取,再删
		getHibernateTemplate().delete(t);
	}
	//改
	public void update(T t) {
		getHibernateTemplate().update(t);
	}
	//查 （根据id查询）
	public T getById(Serializable id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}
	//查 （符合条件的总记录数）
	public Integer getTotalCount(DetachedCriteria dc) {
		//设置查询的聚合函数,总记录数（封装条件）
		dc.setProjection(Projections.rowCount());
		//查询总记录数，并获取返回值
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		//清空之前设置的聚合函数
		dc.setProjection(null);
		
		if(list!=null && list.size()>0){
			Long count = list.get(0);
			return count.intValue();//转换成integer类型
		}else{
			return null;
		}
	}
	//查（ 查询分页列表数据）
	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		//注：这个查询是分页查询
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
		
		return list;
	}
	


}

