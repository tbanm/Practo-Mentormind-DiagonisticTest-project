package com.DiagnosticsTest.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.DiagnosticsTest.entity.User;
import com.DiagnosticsTest.repository.UserRepository;

@Service("userService")
public class UserService {

	private UserRepository userRepository;
	

	
	public UserService(UserRepository userRepository) {
		
		this.userRepository = userRepository;
		
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User findByConfirmationToken(String confirmationToken) {
		return userRepository.findByConfirmationToken(confirmationToken);
	}
	
	public void saveUser(User user) {
		
		
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        // encrypt the password using spring security
        user.setPassword(user.getPassword());

		userRepository.save(user);
	}
	
	public List<User> findAll() {
		
		return userRepository.findAll();
	}

}
