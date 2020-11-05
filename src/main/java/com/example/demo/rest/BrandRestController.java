package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Brand;
import com.example.demo.model.User;
import com.example.demo.service.BrandService;

@RestController
@RequestMapping("/api")
public class BrandRestController {
	
	@Autowired
	BrandService brandService;
	
	@GetMapping(value="brand")
	public ResponseEntity<List<Brand>> getAllBrands(){
		return ResponseEntity.ok(brandService.getAllBrands());
	}

	
	
	@GetMapping(value="brand/{id}")
	public ResponseEntity<Brand> getBrandById(@PathVariable("id") Integer id){
		
		try {

			Brand brand = brandService.getBrandById(id);
			
			return ResponseEntity.ok(brand);
		
		} catch (Exception e) {

			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/brand/") // silmek istedigimiz objeyi gondeririz
	public ResponseEntity<Brand> deleteBrand(@RequestBody Brand brand)

	{
		
		if (brand != null) {
			System.out.println(brand);
			brandService.deleteBrand(brand);
			return ResponseEntity.ok().build();
		}
		else {
		System.out.println("brand yok");
		return new ResponseEntity("There is no object",HttpStatus.NOT_FOUND);
		}


}
}
