package com.ws.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.ws.dao.UserDao;
import com.ws.domain.Sys_User;

public class UserDaoImpl extends BaseDaoImpl<Sys_User> implements UserDao{

	public Sys_User getByUserCode(final String user_userName) {
		//HQL
		/*return getHibernateTemplate().execute(new HibernateCallback<Sys_User>() {
			public Sys_User doInHibernate(Session session) throws HibernateException {
					String hql = "from sys_user where user_userName = ? ";
					Query query = session.createQuery(hql);
					query.setParameter(0, user_userName);
					Sys_User user = (Sys_User) query.uniqueResult();
				return user;
			}
		});*/
		//Criteria
		DetachedCriteria dc = DetachedCriteria.forClass(Sys_User.class);
		
		dc.add(Restrictions.eq("user_userName", user_userName));
		
		List<Sys_User> list = (List<Sys_User>) getHibernateTemplate().findByCriteria(dc);
			
		if(list != null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

}
