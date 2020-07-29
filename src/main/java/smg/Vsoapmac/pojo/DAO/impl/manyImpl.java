package smg.Vsoapmac.pojo.DAO.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import smg.Vsoapmac.pojo.manyInterface;
import smg.Vsoapmac.pojo.DAO.bean.many;
import smg.Vsoapmac.pojo.DAO.bean.one;

public class manyImpl extends HibernateDaoSupport implements manyInterface{

	@Override
	public void save(many info, int one_id) {
		
	}

	@Override
	public List<many> show() {
		return getHibernateTemplate().execute(new HibernateCallback<List<many>>() {
			@Override
			public List<many> doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(many.class);
				return criteria.list();
			}
		});
	}

}
