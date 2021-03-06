package com.amol.Controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.amol.Entity.Product;
import com.amol.Repository.AuthorRepository;
import com.amol.Repository.ProductRepository;
import com.amol.Repository.PublisherRepository;

@RestController
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/product")
public class ProductController {

	@Autowired
	AuthorRepository authRepo;
	@Autowired
	ProductRepository prodRepo;
	@Autowired
	PublisherRepository pubRepo;
	
	
	
	@GetMapping("/all")
	public List<Product> getAllProduct(){
		return this.prodRepo.findAll();
	}
	
	//==================Find Prod By Genre Id
	@GetMapping("/by-gen-id/{id}")
	public List<Product> findProductsByGenreId(@PathVariable("id")Integer id){
		return this.prodRepo.findAllByGenreId(id);
	}
	
	@GetMapping("/by-lang-id/{id}")
	public List<Product> findProductsByLanguageId(@PathVariable("id")Integer id){
		return this.prodRepo.findAllByLanguageId(id);
	}
	
	@GetMapping("/by-cate-id/{id}")
	public List<Product> findProductsByCategoryId(@PathVariable("id")Integer id){
		return this.prodRepo.findAllByCategoryId(id);
	}
	
	@GetMapping("/user/{id}")
	public List<Product> getProdsByAuthorId(@PathVariable("id") Integer id){
		return this.prodRepo.getAllByAuthorsAuth_id(id);
	}
	
	///=======================================================

	@GetMapping("/{id}")
	public Optional<Product> getProductById(@PathVariable("id")Integer id) {
		return this.prodRepo.findById(id);
	}
//	@PostMapping("/")
//	public Product saveProduct(@RequestBody Product product) {
//		return this.prodRepo.save(product);
//	}
	
	
	@PostMapping("/")
	public Product saveProduct(@RequestBody Product product) {
		
		product.setAvl_date(new Date(System.currentTimeMillis()));
		if(product.getPublisher().getPub_id()==null) 
			product.setPublisher(this.pubRepo.save(product.getPublisher()));
		
		if(product.getAuthors()!=null) {
			System.out.println("1");
			
			 //SAVING AUTHOR IF ALREADY EXIST
			 product.setAuthors(product.getAuthors().stream().map(
					 (pro)->{
						 if(pro.getAuth_id()!=null && pro.getAuth_id()>0)
							 pro=authRepo.getById(pro.getAuth_id());
						 return pro;
					 	}
					 ).collect(Collectors.toList()) );
			
			
			
			System.out.println("2");
			;
			System.out.println("3");
			return this.prodRepo.save(product);
		}
		
		return this.prodRepo.save(product);
	}
	
//	@PostMapping("/all")
//	public String saveAllProduct(@RequestBody List<Product> productL) {
//		if(productL.get(0)!=null) {
//			for(Product p:productL) {
//				//SAVING AUTHOR IF ALREADY EXIST
//				 p.setAuthors(p.getAuthors().stream().map(
//						 (pro)->{
//							 if(pro.getAuth_id()!=null && pro.getAuth_id()>0)
//								 pro=authRepo.getById(pro.getAuth_id());
//							 return pro;
//						 	}
//						 ).collect(Collectors.toList()) );
//			}
//			this.prodRepo.saveAll(productL);
//			return "PRODUCTs SAVED SUCCESSFULLY";
//		}
//		
//		return "FAILED..!! PLEASE TRY AGAIN";
//	}
	
	@PutMapping("/")
	public Product updateProduct(@RequestBody Product product) {
		return this.prodRepo.save(product);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable("id")Integer id) {
		if(this.prodRepo.existsById(id)) {
			this.prodRepo.deleteById(id);
			return "PRODUCT DELETED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	
	
	
	
	
}
