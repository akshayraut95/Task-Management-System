package com.ex.service;

import java.util.List;

import com.ex.module.User;

public interface UserService {

	User saveUser(User user);
	
    User getUserById(Long id);
    
    List<User> getAllUsers();
    
    void deleteUser(Long id);
}
