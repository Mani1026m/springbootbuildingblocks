package com.stac.simplify.restservices.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stac.simplify.restservices.entities.User;
import com.stac.simplify.restservices.exceptions.UserNotFoundException;
import com.stac.simplify.restservices.repositories.UserRepository;

//Service
@Service
public class UserService {
	
	//Autowire the user repository
	@Autowired
	private UserRepository userRepository;

	//getAllUsers method
	public List<User> getAllUsers(){
	
		return userRepository.findAll();
	}
	
	
	//CreateUserMethod
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	//Get user by ID
	public Optional<User> getUserById(Long id) throws UserNotFoundException{
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found in user repository");
		}
		return user;
	}
	
	
	
	//UpdateUserById
	
	public User updateUserById(Long id, User user) {
		user.setId(id);
		return userRepository.save(user);
	}
	
	//deleteUserById
	public void deleteUserById(Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			
		}
	}
	

	//getUserByUsername
	
//	public User getUserByUsername(String username) {
//		return userRepository.findByUsername(username);
//	}
	
	
}
