package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> getByName(String firstName) {
		return userRepository.findByFirstName(firstName);
	}
	
	public List<User> getAllUsers(){
		
		return userRepository.findAll();
	}
	
	public User getUserById(Integer id) {
		
		return userRepository.getOne(id);
	}
	
	public void saveOrUpdateUser(User user) {
		userRepository.save(user);
		
	}
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
}
