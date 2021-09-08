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
	
	//=============My-JPQL===========================
	@GetMapping("/by-cate-id/{id}")
	public List<Genre> getAllGenreByCategoryId(@PathVariable("id")Integer id){
		return this.genRepo.getAllByCategryId(id);
	}
	
	@GetMapping("/by-lang-id/{id}")
	public List<Genre> getAllGenreByLanguageId(@PathVariable("id")Integer id){
		return this.genRepo.getAllByLanguageId(id);
	}
	//==================END===========================
	
	
	@GetMapping("/all")
	public List<Genre> getAllGenre(){
		return this.genRepo.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Optional<Genre> getGenreById(@PathVariable("id")Integer id) {
		return this.genRepo.findById(id);
	}
	
	
	@PostMapping("/")
	public Genre saveGenre(@RequestBody Genre gen) {
		return this.genRepo.save(gen);
	}
	
	@PutMapping("/")
	public Genre updateGenre(@RequestBody Genre gen) {
		return this.genRepo.save(gen);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") Integer id) {
		this.genRepo.deleteById(id);
		return "DELETED";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
