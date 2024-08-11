package com.royal.controller;

import com.ecommerce.be_ecommerce.exception.OrderException;
import com.ecommerce.be_ecommerce.exception.UserException;
import com.ecommerce.be_ecommerce.model.Address;
import com.ecommerce.be_ecommerce.model.Order;
import com.ecommerce.be_ecommerce.model.User;
import com.ecommerce.be_ecommerce.service.OrderService;
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
@RequestMapping("/api/orders")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Order", description = "APIs for Order Management")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @Operation(summary = "Create order")
    @ApiResponse(responseCode = "201", description = "Order created")
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Address shippingAddress,
            @RequestHeader("Authorization") String token) throws UserException, OrderException {
        User user = userService.findUserProfileByJwt(token);
        Order order = orderService.createOrder(user, shippingAddress);
        return new ResponseEntity<Order>(order, HttpStatus.CREATED);
    }

    @Operation(summary = "Get user orders history")
    @ApiResponse(responseCode = "201", description = "List of orders")
    @GetMapping("/user")
    public ResponseEntity<List<Order>> userOrderHistory(@RequestHeader("Authorization") String token)
            throws UserException {
        User user = userService.findUserProfileByJwt(token);
        List<Order> orders = orderService.userOrderHistory(user.getId());
        return new ResponseEntity<List<Order>>(orders, HttpStatus.CREATED);
    }

    @Operation(summary = "Get order by id")
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> findOrderById(
            @PathVariable Long orderId,
            @RequestHeader("Authorization") String token) throws UserException, OrderException {
        User user = userService.findUserProfileByJwt(token);
        Order order = orderService.findOrderById(orderId);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
