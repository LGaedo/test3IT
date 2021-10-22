package com.test.tresIT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.tresIT.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findAll();
	Boolean existsByMail(String mail);

}
