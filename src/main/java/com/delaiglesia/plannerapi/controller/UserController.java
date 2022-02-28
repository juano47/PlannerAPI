package com.delaiglesia.plannerapi.controller;

import com.delaiglesia.plannerapi.model.User;
import com.delaiglesia.plannerapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	//this component is injected using constructor injection but
	//with less boilerplate using the @RequiredArgsConstructor lombok annotation
	private final UserService userService;

	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable int id) throws EntityNotFoundException {
		return userService.getUser(id);
	}

	@PostMapping
	public User saveUser(@RequestBody User user){
		return userService.saveUser(user);
	}

	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable int id){
		return userService.updateUser(user, id);
	}

	@DeleteMapping("{id}")
	public boolean deleteUser(@PathVariable int id){
		return userService.deleteUser(id);
	}
}
