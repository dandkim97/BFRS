package com.revature.data.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Plane;
import com.revature.beans.Review;
import com.revature.data.PlaneDao;
import com.revature.data.ReviewDao;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class ReviewHibernate implements ReviewDao{
	
	@Autowired
	private HibernateUtil hu = HibernateUtil.getInstance();
	private PlaneDao pd = new PlaneHibernate();

	@Override
	public Integer addReview(Review r) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(r);
			t.commit();
		} catch (HibernateException e) {
			t.rollback();
			LogUtil.logException(e, ReviewHibernate.class);
		} finally {
			s.close();
		}
		return i;
	}

	@Override
	public Review getReviewById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> getReviewsByCustomer(Integer c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> getReviewsByPlane(Integer p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateReview(Review r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Review getReviewByUidModel(Integer uid, String model) {
		Session s = hu.getSession();
		Plane p = pd.getPlane(model);
		String query = "from Review r where r.customer.id=:uid and r.plane.id=:pid";
		Query<Review> q = s.createQuery(query);
		q.setParameter("uid", uid);
		q.setParameter("pid", p.getId());
		Review r;
		try {
			r = q.uniqueResult();
		} catch (Exception e) {
			r = new Review();
		}
		s.close();
		return r;
	}

}
