package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Review;
import com.revature.services.ReviewService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/review")
public class ReviewController {
	
	@Autowired
	private ReviewService rs;
	
	@PostMapping
	public ResponseEntity<Review> addReview(@RequestBody Review r){
		System.out.println(r);
		rs.addReview(r);
		return ResponseEntity.status(201).body(r);
	}
	
	@GetMapping(value="{uid}/{model}")
	public ResponseEntity<Review> getReview(@PathVariable Integer uid, @PathVariable String model){
		System.out.println("uid: " + uid);
		System.out.println("model: " + model);
		Review r = new Review();
		r = rs.getReview(uid, model);
		return ResponseEntity.status(200).body(r);
	}

}
