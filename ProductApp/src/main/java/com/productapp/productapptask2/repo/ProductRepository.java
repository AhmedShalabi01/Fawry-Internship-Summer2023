package com.productapp.productapptask2.repo;

import com.productapp.productapptask2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
