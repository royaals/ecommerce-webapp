package com.royal.controller;

import com.ecommerce.be_ecommerce.exception.ProductException;
import com.ecommerce.be_ecommerce.exception.UserException;
import com.ecommerce.be_ecommerce.model.Rating;
import com.ecommerce.be_ecommerce.model.User;
import com.ecommerce.be_ecommerce.request.RatingRequest;
import com.ecommerce.be_ecommerce.service.RatingService;
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
@RequestMapping("/api/ratings")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Rating", description = "APIs for Rating Management")
public class RatingController {
    @Autowired
    private UserService userService;

    @Autowired
    private RatingService ratingService;

    @Operation(description = "Create Rating")
    @ApiResponse(responseCode = "201", description = "Rating created")
    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody RatingRequest req,
            @RequestHeader("Authorization") String token)
            throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(token);
        Rating rating = ratingService.createRating(req, user);
        return new ResponseEntity<Rating>(rating, HttpStatus.CREATED);

    }

    @Operation(description = "Get Product's Rating")
    @ApiResponse(responseCode = "200", description = "List of ratings")
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Rating>> getProductsRating(@PathVariable Long productId,
            @RequestHeader("Authorization") String token) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(token);
        List<Rating> ratings = ratingService.getProductsRating(productId);
        return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
    }
}
