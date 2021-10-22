package com.test.tresIT.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.tresIT.dto.UserDTO;
import com.test.tresIT.service.UserService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAll() {
		try {
			List<UserDTO> users = new ArrayList<UserDTO>();

			userService.findAll().forEach(users::add);

			if (users.isEmpty()) {
				System.out.println("no hay usuarios");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			System.out.println("enviando usuarios");
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
		try {
			Boolean exist = userService.existsByMail(user.getMail());
			UserDTO userDTO = new UserDTO();
			if (exist) {
				userDTO.setComentario("existe");
			} else if(!user.getMail().equals("")){
				userDTO = userService.createUser(user);
			}else {
				userDTO.setComentario("existe");
			}
			return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
