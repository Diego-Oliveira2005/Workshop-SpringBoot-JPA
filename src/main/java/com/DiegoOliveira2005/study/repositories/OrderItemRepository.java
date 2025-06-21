package com.DiegoOliveira2005.study.repositories;

import com.DiegoOliveira2005.study.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


}
