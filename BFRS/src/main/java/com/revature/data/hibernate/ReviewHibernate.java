package com.revature.data.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Review;
import com.revature.data.ReviewDao;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class ReviewHibernate implements ReviewDao{
	
	@Autowired
	private HibernateUtil hu = HibernateUtil.getInstance();

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

}
