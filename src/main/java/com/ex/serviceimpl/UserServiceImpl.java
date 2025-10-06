package com.ex.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ex.module.Role;
import com.ex.module.User;
import com.ex.repository.RoleRepository;
import com.ex.repository.UserRepository;
import com.ex.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User saveUser(User user) {
        // Check if username or email already exists

		if(userRepository.findByUsername(user.getUsername()).isPresent())
		{
            throw new RuntimeException("Username already exists!");
	
		}
		if(userRepository.existsByEmail(user.getEmail()))
				{
            throw new RuntimeException("Email already exists!");

				}
		
		 // Encode password
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        if(user.getRoles() == null || user.getRoles().isEmpty()) {
            Role defaultRole = roleRepository.findByName("ROLE_USER");
            user.getRoles().add(defaultRole);
        }
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
		userRepository.deleteById(id);
	}

}
