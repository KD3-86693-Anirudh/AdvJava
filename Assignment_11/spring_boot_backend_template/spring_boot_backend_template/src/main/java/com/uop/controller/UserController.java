package com.uop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uop.dto.UserDTO;
import com.uop.pojos.User;
import com.uop.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	public UserController() {
		super();
	}

	@PostMapping("/")
	public ResponseEntity<?> addUser(@RequestBody UserDTO user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
	}

}
