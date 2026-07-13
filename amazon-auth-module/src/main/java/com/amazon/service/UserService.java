package com.amazon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.model.UserRequest;
import com.amazon.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public boolean register(UserRequest user) {
        if (userRepository.findUserByEmail(user.getEmail()) != null) {
            return false; // User already exists
        }
        userRepository.saveUser(user);
        return true;
    }
	
	public UserRequest login(String email, String password) {
        UserRequest user = userRepository.findUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user; // Login successful
        }
        return null; // Login failed
    }
	
	public boolean resetPassword(String email, String newPassword) {
        UserRequest user = userRepository.findUserByEmail(email);
        if (user != null) {
            userRepository.updatePassword(email, newPassword);
            return true;
        }
        return false;
    }
	

}
