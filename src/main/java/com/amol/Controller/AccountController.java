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

import com.amol.Entity.Account;
import com.amol.Repository.AccountRepostory;
import com.amol.Repository.AuthorRepository;
import com.amol.Repository.PublisherRepository;

@RestController
//@CrossOrigin(origins ="http://localhost:3000", allowedHeaders = "*")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/account")
public class AccountController {

	
	@Autowired
	AccountRepostory accRepo;
	
	@Autowired
	AuthorRepository authRepo;
	
	@Autowired
	PublisherRepository pubRepo;
	
	
	@GetMapping("/pub/{pub_id}")
	public Account getAccountByPublisher(@PathVariable("pub_id") Integer pub_id) {
		return this.pubRepo.getAccountByPubId(pub_id);
	}
	
	@GetMapping("/auth/{pub_id}")
	public Account getAccountByAuthorId(@PathVariable("auth_id") Integer auth_id) {
		return this.authRepo.getAccountByAuthId(auth_id);
	}
	
	@GetMapping("/all")
	public List<Account> getAllAccount(){
		return this.accRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Account> getAccountById(@PathVariable("id")Integer id) {
		System.out.println("\naaaaa\n"+this.accRepo.findById(id));
		return this.accRepo.findById(id);
	}
	
	
	@PostMapping("/")
	public String saveAccount(@RequestBody Account account) {
		if(account!=null) {
			this.accRepo.save(account);
			return "ACCOUNT SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PostMapping("/all")
	public String saveAllAccount(@RequestBody List<Account> account) {
		if(account.get(0)!=null) {
			this.accRepo.saveAll(account);
			return "ACCOUNTs SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PutMapping("/")
	public String updateAccount(@RequestBody Account account) {
		if(this.accRepo.existsById(account.getAcc_id())) {
			this.accRepo.save(account);
			return "ACCOUNT UPDATED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@DeleteMapping("/{id}")
	public String deleteAccount(@PathVariable("id")Integer id) {
		if(this.accRepo.existsById(id)) {
			this.accRepo.deleteById(id);
			return "ACCOUNT DELETED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
}
