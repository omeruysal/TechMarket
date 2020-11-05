package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Brand;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByUser(User user);
	List<Product> findByCategory(Category category);
	List<Product> findByBrand(Brand brand);
}
