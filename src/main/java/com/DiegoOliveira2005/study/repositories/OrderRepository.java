package com.DiegoOliveira2005.study.repositories;

import com.DiegoOliveira2005.study.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {


}
