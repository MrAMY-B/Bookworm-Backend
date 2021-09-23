package com.amol.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> authenticateUser(@RequestBody User user) {
		User  u = this.userRepo.authenticateUser(user.getEmail(),user.getPass());
		
		if(u!=null)
			return new ResponseEntity<User>(u,HttpStatus.OK);

		return new ResponseEntity<>("INVALID CREDENTIAL",HttpStatus.UNAUTHORIZED);
	}

	@PostMapping("/admin")
	public ResponseEntity<String> authenticateAdmin(@RequestBody User user) {
		if(user.getEmail().equalsIgnoreCase("amol@gmail.com") && user.getPass().equalsIgnoreCase("amolbh"))
			return new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		return new ResponseEntity<String>("INVALID CREDENTIAL",HttpStatus.UNAUTHORIZED);
	}
}
