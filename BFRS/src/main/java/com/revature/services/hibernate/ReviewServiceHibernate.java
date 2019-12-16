package com.revature.services.hibernate;

import org.springframework.stereotype.Service;

import com.revature.beans.Review;
import com.revature.data.ReviewDao;
import com.revature.data.hibernate.ReviewHibernate;
import com.revature.services.ReviewService;

@Service
public class ReviewServiceHibernate implements ReviewService{
	
	private ReviewDao rd = new ReviewHibernate();

	@Override
	public void addReview(Review r) {
		rd.addReview(r);
		
	}

}
