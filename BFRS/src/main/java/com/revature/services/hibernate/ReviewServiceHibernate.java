package com.revature.services.hibernate;

import org.springframework.stereotype.Service;

import com.revature.beans.Review;
import com.revature.data.PlaneDao;
import com.revature.data.ReviewDao;
import com.revature.data.hibernate.PlaneHibernate;
import com.revature.data.hibernate.ReviewHibernate;
import com.revature.services.ReviewService;

@Service
public class ReviewServiceHibernate implements ReviewService{
	
	private ReviewDao rd = new ReviewHibernate();
	private PlaneDao pd = new PlaneHibernate();

	@Override
	public void addReview(Review r) {
		rd.addReview(r);
		Integer currRating = r.getPlane().getAvgRating();
		Integer newRating = (currRating + r.getRating()) / 2;
		r.getPlane().setAvgRating(newRating);
		pd.updatePlane(r.getPlane());
		
	}

}
