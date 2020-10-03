package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserInformation;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/all-users")
	private ResponseEntity<List<UserDTO>> getAllUsers() {

		return new ResponseEntity<List<UserDTO>>(userService.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping(value = "/all-users/{name}")
	private ResponseEntity<UserDTO> getAllUsersByName(@PathVariable(value = "name") String name) {

		return new ResponseEntity<UserDTO>(userService.getAllUsersByName(name), HttpStatus.OK);
	}

	@PostMapping(value = "/user")
	private ResponseEntity<UserDTO> addUser(@RequestBody UserInformation user) {

		UserDTO res = userService.saveUser(user);

		return new ResponseEntity<UserDTO>(res, HttpStatus.CREATED);
	}

}
