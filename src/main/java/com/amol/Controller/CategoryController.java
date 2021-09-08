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

import com.amol.Entity.Category;
import com.amol.Repository.CategoryRepository;
import com.amol.Repository.GenreRepository;
import com.amol.Repository.LanguageRepository;

@RestController
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryRepository cateRepo;
	
	@Autowired
	LanguageRepository langRepo;
	
	@Autowired 
	GenreRepository genRepo;
	
	
	//====================MY-JPQL===================
	
	///----------FIND_CATEGORY_BY_LANG_ID
	@GetMapping("/by-lang-id/{id}")
	public Category getCategoryByLanguage(@PathVariable("id")Integer lang_id) {
		return this.langRepo.findCategoryByLanguageId(lang_id);
	}
	
	////---------FIND_CATEGORY_BY_GENRE_ID
	@GetMapping("/by-gen-id/{id}")
	public Category getCategoryByGenreId(@PathVariable("id")Integer gen_id) {
		return this.genRepo.findCategoryByGenreId(gen_id);
	}
	
	//====================JPQL-END===================
	
	

	@GetMapping("/all")
	public List<Category> getAllCategory(){
		return this.cateRepo.findAll();
	}


	
	@GetMapping("/{id}")
	public Optional<Category> getCategoryById(@PathVariable("id") Integer id) {
		return this.cateRepo.findById(id);
	}
	
	
	@PostMapping("/")
	public Category saveCategory( @RequestBody Category cate) {
			return this.cateRepo.save(cate);
	}
	
	
	@PutMapping("/")
	public Category updateCategory( @RequestBody Category cate) {
			return this.cateRepo.save(cate);
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable("id") Integer id) {
		 this.cateRepo.deleteById(id);
		return "DELETED :"+id;
	}
	
	
	
	
	
	
	
	
	
}

