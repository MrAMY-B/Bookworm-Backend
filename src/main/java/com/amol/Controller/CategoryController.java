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

@RestController
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryRepository cateRepo;
	
	@GetMapping("/all")
	public List<Category> getAllCategory(){
		return this.cateRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Category> getCategoryById(@PathVariable("id")Integer id) {
		return this.cateRepo.findById(id);
	}
	
	
	@PostMapping("/")
	public String saveCategory(@RequestBody Category category) {
		if(category!=null) {
			this.cateRepo.save(category);
			return "CATEGORY SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PostMapping("/all")
	public String saveAllCategory(@RequestBody List<Category> categoryl) {
		if(categoryl.get(0)!=null) {
			this.cateRepo.saveAll(categoryl);
			return "CATEGORYs SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PutMapping("/")
	public String updateCategory(@RequestBody Category category) {
		if(this.cateRepo.existsById(category.getCate_id())) {
			this.cateRepo.save(category);
			return "CATEGORY UPDATED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable("id")Integer id) {
		if(this.cateRepo.existsById(id)) {
			this.cateRepo.deleteById(id);
			return "CATEGORY DELETED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}

	
}
