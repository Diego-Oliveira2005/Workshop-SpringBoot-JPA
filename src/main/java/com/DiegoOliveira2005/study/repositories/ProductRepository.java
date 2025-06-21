package com.DiegoOliveira2005.study.repositories;

import com.DiegoOliveira2005.study.entities.Category;
import com.DiegoOliveira2005.study.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}