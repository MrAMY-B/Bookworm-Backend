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

import com.amol.Entity.Publisher;
import com.amol.Repository.PublisherRepository;

@RestController
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/publisher")
public class PublisherController {

	@Autowired
	PublisherRepository pubRepo;
	
	
	@GetMapping("/all")
	public List<Publisher> getAllPublisher(){
		return this.pubRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Publisher> getPublisherById(@PathVariable("id")Integer id) {
		return this.pubRepo.findById(id);
	}
	
	
	@PostMapping("/")
	public String savePublisher(@RequestBody Publisher publisher) {
		if(publisher!=null) {
			this.pubRepo.save(publisher);
			return "PUBLISHER SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PostMapping("/all")
	public String saveAllPublisher(@RequestBody List<Publisher> publisher) {
		if(publisher.get(0)!=null) {
			this.pubRepo.saveAll(publisher);
			return "PUBLISHERs SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PutMapping("/")
	public String updatePublisher(@RequestBody Publisher publisher) {
		if(this.pubRepo.existsById(publisher.getPub_id())) {
			this.pubRepo.save(publisher);
			return "PUBLISHER UPDATED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@DeleteMapping("/{id}")
	public String deletePublisher(@PathVariable("id")Integer id) {
		if(this.pubRepo.existsById(id)) {
			this.pubRepo.deleteById(id);
			return "PUBLISHER DELETED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
}
