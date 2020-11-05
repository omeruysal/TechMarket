package com.example.demo.web;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.User;

import junit.framework.Assert;

public class TechMarketRestTest {
	private RestTemplate restTemplate;
	
	@Before
	public void setUp() // her test metodlari calismadan once calisir
	{
		restTemplate = new RestTemplate();
	}
	
	@Test
	public void testGetUserById() {
	ResponseEntity<User> response =	restTemplate.getForEntity("http://localhost:8080/api/users/1", User.class);
	
	MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
	MatcherAssert.assertThat(response.getBody().getFirstName(),  Matchers.equalTo("omer"));
	}
	
	@Test
	public void testGetAllUsers() {
	ResponseEntity<List> response =	restTemplate.getForEntity("http://localhost:8080/api/users", List.class);
	
	MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
	List<Map<String, String>> body = response.getBody();
	List<String> firstNames = body.stream().map(i-> i.get("firstName")).collect(Collectors.toList());
	MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("omer"));
	
	}
	
	
	@Test
	public void testSaveUser() {
		User user = new User("ali", "ata", null, "adana", "ali@hot.com", "234");
		
		ResponseEntity<User> response = 
				restTemplate.postForEntity("http://localhost:8080/api/user/add", user,User.class);
		

	MatcherAssert.assertThat(response.getBody().getFirstName(), Matchers.equalTo(user.getFirstName()));
	MatcherAssert.assertThat(response.getBody().getLastName(), Matchers.equalTo(user.getLastName()));
	
	}
	@Test
	public void testDeleteUser() {
		restTemplate.delete("http://localhost:8080/api/userdelete/4");
		try {
			restTemplate.getForEntity("http://localhost:8080/api/user/4", User.class);
			Assert.fail("should have not returned user");
		} catch (RestClientException e) {
			// TODO: handle exception
		}
	}

}
