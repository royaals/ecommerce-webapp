package com.ecommerce.be_ecommerce.controller;

import com.ecommerce.be_ecommerce.exception.UserException;
import com.ecommerce.be_ecommerce.model.User;
import com.ecommerce.be_ecommerce.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@SecurityRequirement(
        name = "Bearer Authentication"
)
@Tag(name = "User", description = "APIs for User Management")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(description = "Get User Profile")
    @ApiResponse(
            responseCode = "200",
            description = "User Profile"
    )
    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfile(@RequestHeader("Authorization") String token) throws UserException {
        User user = userService.findUserProfileByJwt(token);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
