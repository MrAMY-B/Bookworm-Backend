package com.amol.Controller;

import java.sql.Date;
import java.util.ArrayList;
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
import com.amol.Entity.Category;
import com.amol.Entity.Genre;
import com.amol.Entity.Language;
import com.amol.Entity.Product;
import com.amol.Entity.Publisher;
import com.amol.Repository.ProductRepository;

@RestController
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/product")
public class ProductController {

	
	@Autowired
	ProductRepository prodRepo;
	
	
	@GetMapping("/all")
	public List<Product> getAllProduct(){
		return this.prodRepo.findAll();
	}
	

	@GetMapping("/{id}")
	public Optional<Product> getProductById(@PathVariable("id")Integer id) {
		return this.prodRepo.findById(id);
	}
	
	
	@PostMapping("/")
	public String saveProduct(@RequestBody Product product) {
		if(product!=null) {
			
			this.prodRepo.save(product);
			return "PRODUCT SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PostMapping("/all")
	public String saveAllProduct(@RequestBody List<Product> productl) {
		if(productl.get(0)!=null) {
			this.prodRepo.saveAll(productl);
			return "PRODUCTs SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PutMapping("/")
	public String updateProduct(@RequestBody Product product) {
		if(this.prodRepo.existsById(product.getProd_id())) {
			this.prodRepo.save(product);
			return "PRODUCT UPDATED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable("id")Integer id) {
		if(this.prodRepo.existsById(id)) {
			this.prodRepo.deleteById(id);
			return "PRODUCT DELETED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@GetMapping("/save-demo")
	public Product getDemoProduct(){
		
		Product p = new Product();
		Publisher pu = new Publisher(); 
		List<Author> aus = new ArrayList<Author>();
		Category c1=new Category();	c1.setCategory("E-BOOK");
		Language l =new Language();	l.setLanguage("ENGLISH");
		Genre g = new Genre();	g.setGenre("Fictional");
		
		Author a1=new Author(),a2=new Author(),a3=new Author();
		
		a1.setName("Auth1");a2.setName("Auth2");a3.setName("Auth3");
		aus.add(a1);
		aus.add(a2);
		aus.add(a3);
		
		pu.setName("publisher");
		//pu.setProuct(new ArrayList<Product>());
		pu.setEmail("publisher@gmail.com");
		pu.setMobile("8877665554");
		
		p.setCategory(c1);
		p.setLanguage(l);
		p.setGenre(g);
		p.setAuthors(aus);
		p.setTitle("DEMO TITLE");
		p.setPublisher(pu);
		p.setBase_price(1099.00);
		p.setSale_price(1000.00);
		p.setOffer_price(999.00);
		p.setAlv_date(new Date(2021));
		p.setShort_desc("SHORT DESCRIPTION");
		p.setLong_desc("LONG DESCRIPTION WILL GO HERE");
		p.setFront_image_link("image link");
		p.setProduct_link("Product link");
		
		Product pp = this.prodRepo.save(p);
		
		return pp;
	}
	
	
	
	
}
