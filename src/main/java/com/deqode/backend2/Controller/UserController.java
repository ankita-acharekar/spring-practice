package com.deqode.backend2.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deqode.backend2.Model.Employee;
import com.deqode.backend2.Model.Users;
import com.deqode.backend2.Service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	// Create users
	@RequestMapping(value = "/api/create-user", method = RequestMethod.POST, produces = "application/json")
	public Users addNewUser(@RequestBody Users user) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		logger.info("Into the UserController");
		Users users = userService.createUser(user);
		logger.info("Saving user....");
		return users;
	}

	// Get all users
	@RequestMapping(value = "/api/getAllUsers", method = RequestMethod.GET, produces = "application/json")
	public List<Users> getAllUsers() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		logger.info("Into the UserController");
		List<Users> userResponse = userService.getAllUsers();

		return userResponse;
	}

	// Get User by id
	@RequestMapping(value = "/api/getUserById/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Users> getUserById(@PathVariable String id) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		logger.info("Into the UserController");
		Optional<Users> userById = userService.getUserById(id);
		return userById;
	}

	// Update User
	@RequestMapping(value = "/api/updateUser/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Users> updateUser(@PathVariable("id") String id, @RequestBody Users user) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		logger.info("Into the UserController");
		ResponseEntity<Users> users = userService.updateUser(id, user);
		logger.info("Saving updated user....");
		return users;
	}

	// Delete User
	@RequestMapping(value = "/api/deleteUser/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Users> deleteUser(@PathVariable("id") String id) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		logger.info("Into the UserController");
		ResponseEntity<Users> user = userService.deleteUser(id);
		logger.info("Deleting user....");
		return user;
	}
}
