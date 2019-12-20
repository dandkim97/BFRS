package com.revature.services;

import com.revature.beans.Review;

public interface ReviewService {
	public void addReview(Review r);
	public Review getReview(Integer uid, String model);
}
