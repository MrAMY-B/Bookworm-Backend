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

import com.amol.Entity.Language;
import com.amol.Repository.GenreRepository;
import com.amol.Repository.LanguageRepository;

@RestController
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/language")
public class LanguageController {
	
	@Autowired
	LanguageRepository langRepo;
	
	@Autowired
	GenreRepository genRepo;
	
	
	
	//====================MY-JPQL===================
	
	@GetMapping("/by-cate-id/{id}")
	public List<Language> findAllByCategoryId(@PathVariable("id") Integer id){
		return this.langRepo.findAllByCategoryId(id);
	}
	
	@GetMapping("/by-gen-id/{id}")
	public Language getOneLanguageByGenreId(@PathVariable("id")Integer gen_id) {
		return this.genRepo.findLanguageByGenreId(gen_id);
	}
	
	
	//====================JPQL-END===================
	
	@GetMapping("/all")
	public List<Language> getAllLanguage(){
		return this.langRepo.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Optional<Language> getLanguageById(@PathVariable("id")Integer id) {
		return this.langRepo.findById(id);
	}
	
	
	@PostMapping("/")
	public Language saveLanguage(@RequestBody Language lang) {
		return this.langRepo.save(lang);
	}
	
	@PutMapping("/")
	public Language updateLanguage(@RequestBody Language lang) {
		return this.langRepo.save(lang);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") Integer id) {
		this.langRepo.deleteById(id);
		return "DELETED";
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
