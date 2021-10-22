package com.test.tresIT.service;

import java.util.List;

import com.test.tresIT.dto.UserDTO;
import com.test.tresIT.entity.User;

public interface UserService {

	UserDTO createUser(UserDTO user);
	
	List<UserDTO> findAll();

	Boolean existsByMail(String mail);
}
