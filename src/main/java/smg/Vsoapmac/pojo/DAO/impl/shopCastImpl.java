package smg.Vsoapmac.pojo.DAO.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import smg.Vsoapmac.pojo.shopCastInterface;
import smg.Vsoapmac.pojo.DAO.bean.shopcast;

public class shopCastImpl extends HibernateDaoSupport implements shopCastInterface {

	@Override
	public List<shopcast> showCast() {
		HibernateTemplate ht = super.getHibernateTemplate();
		return ht.execute(new HibernateCallback<List<shopcast>>() {
			@Override
			public List<shopcast> doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(shopcast.class);
				return criteria.list();
			}
		});
	}

	@Override
	public shopcast findOneById(final int id) {
		return super.getHibernateTemplate().execute(new HibernateCallback<shopcast>() {
			@Override
			public shopcast doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(shopcast.class);
				criteria.add(Restrictions.eq("id", id));
				return (shopcast) criteria.uniqueResult();
			}
		});
	}

//	用的getbean方式获取sessionFactory，然后用criteria放回list
//	private SessionFactory sf;
//	
//	public shopCastImpl() {
//		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		
//		sf = (SessionFactory) cpx.getBean("sessionFactory");
//	}
//	@Override
//	public List<shopcast> showCast() {
//		Session session = sf.openSession();
//		
//		Criteria criteria = session.createCriteria(shopcast.class);
//		return criteria.list();
//	}

}
