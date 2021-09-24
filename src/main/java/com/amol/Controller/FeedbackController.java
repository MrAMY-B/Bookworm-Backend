package com.amol.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amol.Entity.Feedback;
import com.amol.Repository.FeedbackRepository;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/feedback")
public class FeedbackController {

	
	@Autowired
	FeedbackRepository feedRepo;
	
	@GetMapping("/all")
	public List<Feedback> getAllFeedback(){
		return this.feedRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Feedback getFeedbackById(@PathVariable("id")Integer id) {
		return this.feedRepo.getById(id);
	}
	
	@PostMapping("/save")
	public Feedback saveFeedback(@RequestBody Feedback feed ) {
		return this.feedRepo.save(feed);
	}
	
	@PutMapping("/update")
	public Feedback updateFeedback(@RequestBody Feedback feed ) {
		return this.feedRepo.save(feed);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id")Integer id) {
		if(this.feedRepo.existsById(id)) {
			this.feedRepo.deleteById(id);
			return "SUCCESSFULLY DELETED";
		}
	return "NOT FOUND";
	}
	
	
	
//	
//	@PostMapping
//	@PutMapping
//	@DeleteMapping
	
	
}
