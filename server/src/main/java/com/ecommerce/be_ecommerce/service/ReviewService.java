package com.ecommerce.be_ecommerce.service;

import com.ecommerce.be_ecommerce.exception.ProductException;
import com.ecommerce.be_ecommerce.model.Review;
import com.ecommerce.be_ecommerce.model.User;
import com.ecommerce.be_ecommerce.request.ReviewRequest;

import java.util.List;

public interface ReviewService {
    public Review createReview(ReviewRequest req, User user) throws ProductException;
    public List<Review> getAllReview(Long productId);
}
