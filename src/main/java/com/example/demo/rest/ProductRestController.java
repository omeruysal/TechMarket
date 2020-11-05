package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Brand;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {
	@Autowired
	ProductService productService;
	
	@GetMapping(value="product")
	public ResponseEntity<List<Product>> getAllProducts(){
		return ResponseEntity.ok(productService.getAllProducts());
	}
	
	@GetMapping(value="product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id){
		
		try {

			Product product = productService.getProductById(id);
			
			return ResponseEntity.ok(product);
		
		} catch (Exception e) {

			return ResponseEntity.notFound().build();
		}
		
	}

	@RequestMapping(method=RequestMethod.POST,value="/product/brand")
	public ResponseEntity<List<Product>> getProductByBrand(@RequestBody Brand brand){
		
		try {

			List<Product> product = productService.getProductByBrand(brand);
			
			return ResponseEntity.ok(product);
		
		} catch (Exception e) {

			return ResponseEntity.notFound().build();
		}
		
	}


	@RequestMapping(method=RequestMethod.POST,value="/product/user")
	public ResponseEntity<List<Product>> getProductByUser(@RequestBody User user){
		
		try {

			List<Product> product = productService.getProductByUser(user);
			
			return ResponseEntity.ok(product);
		
		} catch (Exception e) {

			return ResponseEntity.notFound().build();
		}
		
	}
	
	

	@RequestMapping(method=RequestMethod.POST,value="/product/category")
	public ResponseEntity<List<Product>> getProductByCategory(@RequestBody Category category){
		
		try {

			List<Product> product = productService.getProductByCategory(category);
			
			return ResponseEntity.ok(product);
		
		} catch (Exception e) {

			return ResponseEntity.notFound().build();
		}
		
	}
}
