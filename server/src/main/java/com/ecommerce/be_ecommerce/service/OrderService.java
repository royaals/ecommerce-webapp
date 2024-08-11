package com.ecommerce.be_ecommerce.service;

import com.ecommerce.be_ecommerce.exception.OrderException;
import com.ecommerce.be_ecommerce.model.Address;
import com.ecommerce.be_ecommerce.model.Order;
import com.ecommerce.be_ecommerce.model.User;

import java.util.List;

public interface OrderService {
     Order createOrder(User user, Address shippingAddress) throws OrderException;
     List<Order> getAllOrders();
     List<Order> userOrderHistory(Long userId);
     Order placedOrder(Long orderId) throws OrderException;

     Order confirmedOrder(Long orderId) throws OrderException;
    Order shippedOrder(Long orderId) throws OrderException;
    Order deliveredOrder(Long orderId) throws OrderException;
    Order cancelledOrder(Long orderId) throws OrderException;
    Order findOrderById(Long orderId) throws OrderException;

    void deleteOrder(Long orderId) throws OrderException;



}
