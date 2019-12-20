package com.revature.data;

import java.util.List;

import com.revature.beans.Review;

public interface ReviewDao {
	public Integer addReview(Review r);
	public Review getReviewById(Integer id);
	public List<Review> getReviewsByCustomer(Integer c);
	public List<Review> getReviewsByPlane(Integer p);
	public void updateReview(Review r);
}
