package com.DiegoOliveira2005.study.repositories;

import com.DiegoOliveira2005.study.entities.Category;
import com.DiegoOliveira2005.study.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}