package com.amol.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amol.Entity.User;
import com.amol.Repository.UserRepository;

@RestController
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepo;
	
	
	@GetMapping("/all")
	public List<User> getAllUser(){
		return this.userRepo.findAll();
	}
	
	@GetMapping("/all-pass")
	public List<String> getAllPass(){
		return this.userRepo.getAllPasswords();
	}
	
	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable("id")Integer id) {
		return this.userRepo.findById(id);
	}
	
	
	@PostMapping("/")
	public String saveUser(@RequestBody User user) {
		if(user!=null) {
			this.userRepo.save(user);
			return "USER SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PostMapping("/all")
	public String saveAllUser(@RequestBody List<User> user) {
		if(user.get(0)!=null) {
			this.userRepo.saveAll(user);
			return "USERs SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PutMapping("/")
	public String updateUser(@RequestBody User user) {
		if(this.userRepo.existsById(user.getU_id())) {
			this.userRepo.save(user);
			return "USER UPDATED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id")Integer id) {
		if(this.userRepo.existsById(id)) {
			this.userRepo.deleteById(id);
			return "USER DELETED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	
}
