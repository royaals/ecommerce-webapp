package com.ecommerce.be_ecommerce.service.impl;

import com.ecommerce.be_ecommerce.model.OrderItem;
import com.ecommerce.be_ecommerce.repository.OrderItemRepository;
import com.ecommerce.be_ecommerce.service.OrderItemService;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }
    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
