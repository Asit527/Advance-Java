package com.amazon.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.amazon.model.UserRequest;

@Repository
public class UserRepository {
	
	// store in array list
	private List<UserRequest> usersList = new ArrayList<UserRequest>();
	
	
	//method to add new  user
	public void saveUser(UserRequest user) {
		usersList.add(user);
	}
	
	// find user by mail
	public UserRequest findUserByEmail(String email) {
        for (UserRequest u : usersList) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }
	
	//update password
	public void updatePassword(String email, String newPassword) {
        UserRequest user = findUserByEmail(email);
        if (user != null) {
            user.setPassword(newPassword);
        }
    }

	// get all user
    public List<UserRequest> getAllUsers() {
        return usersList;
    }
    
    
}


