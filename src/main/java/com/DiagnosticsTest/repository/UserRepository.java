package com.DiagnosticsTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DiagnosticsTest.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	
	 User findByConfirmationToken(String confirmationToken);
	 
	  List<User> findAll();

}
