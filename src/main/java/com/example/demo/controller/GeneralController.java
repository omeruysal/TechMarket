package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Controller
public class GeneralController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/")
	public ModelAndView welcome() {
		List<User> list = userService.getAllUsers();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("home");
		return mav;
	}
	
	
	
	@RequestMapping(value="users") // restpi seklinde calisir
	@ResponseBody
	public ResponseEntity<List<User>> getAllProducts(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	
	@RequestMapping(value="user") // restpi seklinde calisir
	@ResponseBody
	public String getone(){
		return userService.getUserById(1).toString();
	}
	
	
	
	@RequestMapping("/hello2")
	public String home2() {
		return "home.jsp";
	}
	@RequestMapping("/hello")
	@ResponseBody
	public String home() {
		return "hello";
	}
	

}
