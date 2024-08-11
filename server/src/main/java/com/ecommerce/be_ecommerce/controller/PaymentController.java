package com.ecommerce.be_ecommerce.controller;

import com.ecommerce.be_ecommerce.exception.OrderException;
import com.ecommerce.be_ecommerce.model.Order;
import com.ecommerce.be_ecommerce.repository.OrderRepository;
import com.ecommerce.be_ecommerce.response.PaymentLinkResponse;
import com.ecommerce.be_ecommerce.service.OrderService;
import com.ecommerce.be_ecommerce.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@SecurityRequirement(
        name = "Bearer Authentication"
)
public class PaymentController {
    @Value("${stripe.publish.key}")
    private String stripePublishKey;

    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderRepository orderRepository;

//    @PostMapping("/payments/{orderId}")
//    public ResponseEntity<PaymentLinkResponse> createPaymentLink(
//            @PathVariable Long orderId, @RequestHeader("Authorization") String token
//    ) throws OrderException{
//        Order order = orderService.findOrderById(orderId);
//        try{
//
//        }
//    }
}
