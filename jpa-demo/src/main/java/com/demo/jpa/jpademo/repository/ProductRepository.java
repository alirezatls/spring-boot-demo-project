package com.demo.jpa.jpademo.repository;

import com.demo.jpa.jpademo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
