package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserInformation;

public interface UserService {

	List<UserDTO> getAllUsers();
	UserDTO saveUser(UserInformation user);
	UserDTO getAllUsersByName(String name);
}
