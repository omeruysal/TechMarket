package com.example.demo.rest;

import java.util.List;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {
	
	@Autowired
	UserService userService;
	

	
	@GetMapping(value="users")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}

	
	
	@GetMapping(value="users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id){
		
		try {

			User user = userService.getUserById(id);
			
			return ResponseEntity.ok(user);
		
		} catch (Exception e) {

			return ResponseEntity.notFound().build();
		}
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/add") // eklemek istedigimiz objeyi gondeririz
	public ResponseEntity<User> addUser(@RequestBody User user)

	{
		
		if (user != null) {
			System.out.println(user);
			userService.saveOrUpdateUser(user);
			return ResponseEntity.ok(user);
		}
		else {
		System.out.println("user eklenemedi");
		return new ResponseEntity("There is no object",HttpStatus.INTERNAL_SERVER_ERROR); //500e denk gelir
		}

	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/user") // silmek istedigimiz objeyi gondeririz
	public ResponseEntity<User> deleteUser(@RequestBody User user)

	{
		
		if (user != null) {
			System.out.println(user);
			userService.deleteUser(user);
			return ResponseEntity.ok().build();
		}
		else {
		System.out.println("user yok");
		return new ResponseEntity("There is no object",HttpStatus.NOT_FOUND);
		}

	}
	
	

	@RequestMapping(method = RequestMethod.DELETE, value = "/userdelete/{id}") // silmek istedigimiz objenin id sini gondeririz
	public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id)

	{
		User user = userService.getUserById(id);
		System.out.println(user);
		if (user != null) {
			userService.deleteUser(user);
			return ResponseEntity.ok().build();
		}
		return new ResponseEntity("There is no object",HttpStatus.NOT_FOUND);

	}
	
	
	
	
	
	
//	

}
