package smg.Vsoapmac.pojo.DAO.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import smg.Vsoapmac.pojo.antheroneInterface;
import smg.Vsoapmac.pojo.DAO.bean.anotherone;
import smg.Vsoapmac.pojo.DAO.bean.one;
import smg.Vsoapmac.pojo.DAO.bean.shopcast;

public class antheroneImpl extends HibernateDaoSupport implements antheroneInterface {

	@Override
	public List<anotherone> show() {
		return getHibernateTemplate().execute(new HibernateCallback<List<anotherone>>() {
			@Override
			public List<anotherone> doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(anotherone.class);
				return criteria.list();
			}
		});
	}

}
