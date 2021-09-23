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

import com.amol.Entity.Author;
import com.amol.Entity.Beneficiary;
import com.amol.Repository.AuthorRepository;

@RestController
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/author")
public class AuthorController {

	
	@Autowired
	AuthorRepository authPubRepo;
	
	
	
	@PostMapping("/add-beneficiary/{id}")
	public String saveBeneficiaryToAuthor(@PathVariable("id")Integer auth_id,@RequestBody Beneficiary bene) {

		Author author = authPubRepo.getById(auth_id);
		author.setBeneficiary(bene);
		this.authPubRepo.save(author);
		
		return "Success";
	}
	
	@GetMapping("/all")
	public List<Author> getAllAuthor(){
		return this.authPubRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Author> getAuthorById(@PathVariable("id")Integer id) {
		return this.authPubRepo.findById(id);
	}
	
	
	@PostMapping("/")
	public String saveAuthor(@RequestBody Author authPub) {
		if(authPub!=null) {
			this.authPubRepo.save(authPub);
			return "AUTHOR SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PostMapping("/all")
	public String saveAllAuthor(@RequestBody List<Author> authPub) {
		if(authPub.get(0)!=null) {
			this.authPubRepo.saveAll(authPub);
			return "AUTHORs SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PutMapping("/")
	public String updateAuthor(@RequestBody Author authPub) {
		if(this.authPubRepo.existsById(authPub.getAuth_id())) {
			this.authPubRepo.save(authPub);
			return "AUTHOR UPDATED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@DeleteMapping("/{id}")
	public String deleteAuthor(@PathVariable("id")Integer id) {
		if(this.authPubRepo.existsById(id)) {
			this.authPubRepo.deleteById(id);
			return "AUTHOR DELETED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
}
