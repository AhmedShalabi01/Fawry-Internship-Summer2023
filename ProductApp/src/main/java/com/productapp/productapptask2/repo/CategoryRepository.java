package com.productapp.productapptask2.repo;

import com.productapp.productapptask2.entity.Category;
import com.productapp.productapptask2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
