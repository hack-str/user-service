package com.revature.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping
	public List<User> getAllUsers() {

		return null;
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return null;
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return null;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") int id){
		return null;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		return null;
	}
}
