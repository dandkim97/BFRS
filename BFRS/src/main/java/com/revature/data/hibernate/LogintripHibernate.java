package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Logintrip;
import com.revature.data.LogintripDao;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class LogintripHibernate implements LogintripDao {

	@Autowired
	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public int addLogintrip(Logintrip lt) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(lt);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, FormHibernate.class);
		} finally {
			s.close();
		}
		return lt.getId();
	}
	
	@Override
	public Set<Logintrip> getLogintrips() {
		Session s = hu.getSession();
		String query = "from Logintrip";
		//String query = "from Logintrip order by id asc";
		Query<Logintrip> q = s.createQuery(query, Logintrip.class);
		List<Logintrip> logintrips = q.list();
		s.close();
		return new HashSet<Logintrip>(logintrips);
	}

	@Override
	public void deleteLoginTrip(Logintrip lt) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			System.out.println(lt);
			String nativeSQL = "delete from Login_Trip where id = :id";
			NativeQuery<Logintrip> q = s.createNativeQuery(nativeSQL, Logintrip.class);
			q.setParameter("id", lt.getId());
			q.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, LogintripHibernate.class);
		} finally {
			s.close();
		}
		
	}

	@Override
	public Logintrip getLoginTrip(Integer tId, Integer uId) {
		Session s = hu.getSession();
		String query = "from Logintrip l where l.trip.id = :tId "
				+ "and l.login.id = :uId";
		Query<Logintrip> q = s.createQuery(query, Logintrip.class);
		q.setParameter("tId", tId);
		q.setParameter("uId", uId);
		Logintrip lt = q.uniqueResult();
		s.close();
		return lt;
	}
}
