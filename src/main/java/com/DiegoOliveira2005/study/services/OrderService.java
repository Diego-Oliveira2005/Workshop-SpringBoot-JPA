package com.DiegoOliveira2005.study.services;

import com.DiegoOliveira2005.study.entities.Order;
import com.DiegoOliveira2005.study.repositories.OrderRepository;
import com.DiegoOliveira2005.study.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
