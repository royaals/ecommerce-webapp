package com.royal.controller;

import com.ecommerce.be_ecommerce.exception.OrderException;
import com.ecommerce.be_ecommerce.model.Order;
import com.ecommerce.be_ecommerce.response.ApiResponse;
import com.ecommerce.be_ecommerce.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/orders")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Admin Order", description = "APIs for Admin to manage orders")
public class AdminOrderController {
    @Autowired
    private OrderService orderService;

    @Operation(summary = "Get all orders")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "List of orders")
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }

    @Operation(summary = "Update order status to confirmed")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Updating order to confirmed status")
    @PutMapping("/{orderId}/confirmed")
    public ResponseEntity<Order> confirmedOrder(@PathVariable Long orderId,
            @RequestHeader("Authorization") String token) throws OrderException {
        Order order = orderService.confirmedOrder(orderId);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @Operation(summary = "Update order status to shipped")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Updating order to shipped status")
    @PutMapping("/{orderId}/shipped")
    public ResponseEntity<Order> shippedOrder(@PathVariable Long orderId, @RequestHeader("Authorization") String token)
            throws OrderException {
        Order order = orderService.shippedOrder(orderId);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @Operation(summary = "Update order status to delivered")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Updating order to delivered status")
    @PutMapping("/{orderId}/delivered")
    public ResponseEntity<Order> deliveredOrder(@PathVariable Long orderId,
            @RequestHeader("Authorization") String token) throws OrderException {
        Order order = orderService.deliveredOrder(orderId);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @Operation(summary = "Update order status to cancelled")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Updating order to cancelled status")
    @PutMapping("/{orderId}/cancelled")
    public ResponseEntity<Order> cancelledOrder(@PathVariable Long orderId,
            @RequestHeader("Authorization") String token) throws OrderException {
        Order order = orderService.cancelledOrder(orderId);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @Operation(summary = "Delete order")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Order deleted successfully")
    @DeleteMapping("/{orderId}/delete")
    public ResponseEntity<ApiResponse> deleteOrder(@PathVariable Long orderId,
            @RequestHeader("Authorization") String token) throws OrderException {
        orderService.deleteOrder(orderId);
        ApiResponse res = new ApiResponse();
        res.setMessage("Order deleted successfully");
        res.setStatus(true);
        return new ResponseEntity<ApiResponse>(res, HttpStatus.OK);

    }
}
