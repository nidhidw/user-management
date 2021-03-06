package com.ust.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.user.entity.User;
import com.ust.user.exception.UserNotFoundException;
import com.ust.user.service.UserService;

@RestController
@RequestMapping(value = "/app/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}


	@PostMapping("/create-user")
	public ResponseEntity<User> saveUser(@RequestBody User user) {

		User savedUser = userService.saveUser(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);

	}

	@GetMapping("/retrieve-user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.FOUND);
	}

	@DeleteMapping("delete-user/{id}")
	public ResponseEntity<User> getUserAfterDeleting(@PathVariable("id") int id) {
		return new ResponseEntity<User>(userService.deleteByUserId(id),HttpStatus.OK);
	}
	
	@PutMapping("/edit-user/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable("id") int id) {
       return new ResponseEntity<User>(userService.updateByUserId(id), HttpStatus.OK);
    }



}
