package com.amol.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amol.Entity.User;
import com.amol.Repository.UserRepository;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/user")
	public User authenticateUser(@RequestBody User user) {
		return this.userRepo.authenticateUser(user.getEmail(),user.getPass());
	}

	@PostMapping("/admin")
	public String authenticateAdmin(@RequestBody User user) {
		if(user.getEmail().equalsIgnoreCase("amol@gmail.com") && user.getPass().equalsIgnoreCase("amol"))
			return "SUCCESS";
		return "FAILED";
	}
}
