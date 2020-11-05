package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.jdbcrepository.BrandRepositoryJdbc;
import com.example.demo.model.Brand;
import com.example.demo.model.User;
import com.example.demo.repository.BrandRepository;

@Service
@Transactional
public class BrandService {
	
	@Autowired
	BrandRepositoryJdbc brandRepo;
	@Autowired
	BrandRepository brandRepository;
	
	public List<Brand> getAllBrands(){
		
		return brandRepository.findAll();
	}
	
	public Brand getBrandById(Integer id) {
		
		return brandRepository.getOne(id);
	}
	
	public void saveOrUpdateBrand(Brand brand) {
		brandRepository.save(brand);
		
	}
	public void deleteBrand(Brand brand) {
		brandRepository.delete(brand);
	}
}

