package com.ecommerce.be_ecommerce.controller;

import com.ecommerce.be_ecommerce.exception.ProductException;
import com.ecommerce.be_ecommerce.exception.UserException;
import com.ecommerce.be_ecommerce.model.Review;
import com.ecommerce.be_ecommerce.request.ReviewRequest;
import com.ecommerce.be_ecommerce.service.ReviewService;
import com.ecommerce.be_ecommerce.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@SecurityRequirement(
        name = "Bearer Authentication"
)
@Tag(name = "Review", description = "APIs for Review Management")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserService userService;

    @Operation(description = "Create a Review")
    @ApiResponse(
            responseCode = "201",
            description = "Review created"
    )
    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody ReviewRequest req, @RequestHeader("Authorization") String token) throws UserException, ProductException {
        Review review = reviewService.createReview(req, userService.findUserProfileByJwt(token));
      return new ResponseEntity<Review>(review, HttpStatus.CREATED);
    }

    @Operation(description = "Get Product's Review")
    @ApiResponse(
            responseCode = "200",
            description = "List of reviews"
    )
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Review>> getProductsReview(@PathVariable Long productId) throws UserException,ProductException {
        List<Review> reviews = reviewService.getAllReview(productId);
        return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
    }

}
