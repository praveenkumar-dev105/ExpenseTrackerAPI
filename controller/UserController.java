package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
    
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getAll")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		return userService.deleteById(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	// Update User
	@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable int id,
                           @RequestBody User user) {
        return userService.updateUser(id, user);
    }
}
