package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Brand;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	public Product getProductById(Integer id) {

		return productRepository.getOne(id);
	}

	public List<Product> getProductByUser(User user) {

		return productRepository.findByUser(user);
	}

	public List<Product> getProductByCategory(Category category) {

		return productRepository.findByCategory(category);
	}

	public List<Product> getProductByBrand(Brand brand) {

		return productRepository.findByBrand(brand);
	}

	public void saveOrUpdateUser(Product product) {
		productRepository.save(product);

	}

	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}

}
