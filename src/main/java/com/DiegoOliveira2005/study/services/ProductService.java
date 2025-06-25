package com.DiegoOliveira2005.study.services;

import com.DiegoOliveira2005.study.entities.Product;
import com.DiegoOliveira2005.study.repositories.ProductRepository;
import com.DiegoOliveira2005.study.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
