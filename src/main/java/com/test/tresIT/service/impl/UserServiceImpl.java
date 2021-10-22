package com.test.tresIT.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tresIT.dto.UserDTO;
import com.test.tresIT.entity.User;
import com.test.tresIT.repository.UserRepository;
import com.test.tresIT.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger LOG = Logger.getLogger(UserServiceImpl.class.getName());

	@Override
	public UserDTO createUser(UserDTO user) {
		UserDTO returnValue;
		try {
			User userModel = new User();
			returnValue = new UserDTO();
			LOG.info("se inicia creación de usuario");
			BeanUtils.copyProperties(user, userModel);

			User infoUser = userRepository.save(userModel);
			if (infoUser != null) {
				BeanUtils.copyProperties(infoUser, returnValue);
				returnValue.setComentario("creado");
				LOG.info("usuario creado");
			}

		} catch (Exception e) {
			return null;
		}
		return returnValue;
	}

	@Override
	public List<UserDTO> findAll() {

		List<UserDTO> users = new ArrayList<UserDTO>();
		List<User> usersM = new ArrayList<User>();

		userRepository.findAll().forEach(usersM::add);

		for (User user : usersM) {
			UserDTO u = new UserDTO();
			if (user != null) {
				BeanUtils.copyProperties(user, u);
				users.add(u);
			}
		}
		return users;
	}

	@Override
	public Boolean existsByMail(String mail) {
		Boolean ret = userRepository.existsByMail(mail);
		return ret;
	}

}
