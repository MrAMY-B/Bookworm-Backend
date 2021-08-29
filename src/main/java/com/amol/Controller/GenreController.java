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

import com.amol.Entity.Genre;
import com.amol.Repository.GenreRepository;

@RestController
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/genre")
public class GenreController {

	@Autowired
	GenreRepository genRepo;
	
	@GetMapping("/all")
	public List<Genre> getAllGenre(){
		return this.genRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Genre> getGenreById(@PathVariable("id")Integer id) {
		return this.genRepo.findById(id);
	}
	
	
	@PostMapping("/")
	public String saveGenre(@RequestBody Genre genre) {
		if(genre!=null) {
			this.genRepo.save(genre);
			return "GENRE SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PostMapping("/all")
	public String saveAllGenre(@RequestBody List<Genre> genre) {
		if(genre.get(0)!=null) {
			this.genRepo.saveAll(genre);
			return "GENREs SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PutMapping("/")
	public String updateGenre(@RequestBody Genre genre) {
		if(this.genRepo.existsById(genre.getGen_id())) {
			this.genRepo.save(genre);
			return "GENRE UPDATED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@DeleteMapping("/genre/{id}")
	public String deleteGenre(@PathVariable("id")Integer id) {
		if(this.genRepo.existsById(id)) {
			this.genRepo.deleteById(id);
			return "GENRE DELETED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	
}
