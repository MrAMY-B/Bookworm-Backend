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
import com.amol.Repository.LanguageRepository;

@RestController
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/language")
public class LanguageController {
	
		@Autowired
		LanguageRepository langRepo;
		
		@GetMapping("/all")
		public List<Language> getAllLanguage(){
			return this.langRepo.findAll();
		}
		
		@GetMapping("/{id}")
		public Optional<Language> getLanguageById(@PathVariable("id")Integer id) {
			return this.langRepo.findById(id);
		}
		
		
		@PostMapping("/")
		public String saveLanguage(@RequestBody Language language) {
			if(language!=null) {
				this.langRepo.save(language);
				return "LANGUAGE SAVED SUCCESSFULLY";
			}
			
			return "FAILED..!! PLEASE TRY AGAIN";
		}
		
		@PostMapping("/all")
		public String saveAllLanguage(@RequestBody List<Language> languagel) {
			if(languagel.get(0)!=null) {
				this.langRepo.saveAll(languagel);
				return "LANGUAGEs SAVED SUCCESSFULLY";
			}
			
			return "FAILED..!! PLEASE TRY AGAIN";
		}
		
		@PutMapping("/")
		public String updateLanguage(@RequestBody Language language) {
			if(this.langRepo.existsById(language.getLang_id())) {
				this.langRepo.save(language);
				return "LANGUAGE UPDATED SUCCESSFULLY";
			}
			
			return "FAILED..!! PLEASE TRY AGAIN";
		}
		
		@DeleteMapping("/{id}")
		public String deleteLanguage(@PathVariable("id")Integer id) {
			if(this.langRepo.existsById(id)) {
				this.langRepo.deleteById(id);
				return "LANGUAGE DELETED SUCCESSFULLY";
			}
			
			return "FAILED..!! PLEASE TRY AGAIN";
		}
		
		
		
		
		
		
		
		
		
		
		
		
	

}
