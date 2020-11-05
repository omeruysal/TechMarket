package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Brand;
import com.example.demo.model.Category;
import com.example.demo.model.User;
import com.example.demo.repository.BrandRepository;
import com.example.demo.repository.CategoryRepository;
@Service
@Transactional
public class CategoryService {
	
	@Autowired
	CategoryRepository categorRepository;
	
	public List<Category> getAllCategories() {

		return categorRepository.findAll();
	}

	public Category getCategoryById(Integer id) {

		return categorRepository.getOne(id);
	}

	public void saveOrUpdateCategory(Category category) {
		categorRepository.save(category);

	}

	public void deleteCategory(Category category) {
		categorRepository.delete(category);
	}
}

