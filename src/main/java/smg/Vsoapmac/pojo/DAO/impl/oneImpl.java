package smg.Vsoapmac.pojo.DAO.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import smg.Vsoapmac.pojo.oneInterface;
import smg.Vsoapmac.pojo.DAO.bean.one;

public class oneImpl extends HibernateDaoSupport implements oneInterface{

	@Override
	public List<one> show() {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<one>>() {
			@Override
			public List<one> doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(one.class);
				return criteria.list();
			}
		});
	}

	@Override
	public one findById(final int id) {
		return getHibernateTemplate().execute(new HibernateCallback<one>() {
			@Override
			public one doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(one.class);
				criteria.add(Restrictions.eq("one_id", id));
				return (one) criteria.uniqueResult();
			}
		});
	}
	
}
