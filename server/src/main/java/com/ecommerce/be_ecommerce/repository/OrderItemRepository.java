package com.ecommerce.be_ecommerce.repository;

import com.ecommerce.be_ecommerce.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
