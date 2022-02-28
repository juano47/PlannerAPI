package com.delaiglesia.plannerapi.services;

import com.delaiglesia.plannerapi.model.User;
import com.delaiglesia.plannerapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

	//Constructor injection mode
	private final UserRepository userRepository;
	@Autowired //only use this annotation if exists more than one constructor
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User getUser(int id) throws EntityNotFoundException {
		return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found - " + id));
	}

	public User saveUser(User user){
		if (user.getUserId() != null){
			user.setUserId(null);
		}
		return userRepository.save(user);
	}

	public User updateUser(User user, int id) {
		userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found - " + id));
		user.setUserId(id);
		return userRepository.save(user);
	}

	public boolean deleteUser(int id){
		userRepository.deleteById(id);
		return true;
	}
}
