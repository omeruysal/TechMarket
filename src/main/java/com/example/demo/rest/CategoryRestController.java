package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Brand;
import com.example.demo.model.Category;
import com.example.demo.service.BrandService;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryRestController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping(value="category")
	public ResponseEntity<List<Category>> getAllCategories(){
		
		return ResponseEntity.ok(categoryService.getAllCategories());
	}

	
	
	@GetMapping(value="category/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") Integer id){
		
		try {

			Category category = categoryService.getCategoryById(id);
			
			return ResponseEntity.ok(category);
		
		} catch (Exception e) {

			return ResponseEntity.notFound().build();
		}
		
	}

}
