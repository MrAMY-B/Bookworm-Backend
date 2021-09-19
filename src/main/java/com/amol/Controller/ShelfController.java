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

import com.amol.Entity.Shelf;
import com.amol.Repository.ProductRepository;
import com.amol.Repository.ShelfRepository;
import com.amol.Repository.UserRepository;

@RestController
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/shelf")
public class ShelfController {

	@Autowired
	UserRepository userRepo;
	
	@Autowired 
	ProductRepository prodRepo;
	
	@Autowired
	ShelfRepository shelfRepo;
	
	
	@GetMapping("/user/{id}")
	public List<Shelf> getAllUsersByUserId(@PathVariable("id")Integer id){
		System.out.println("\n\n in /shelf/user/{id}\n");
		return this.shelfRepo.getAllShelfsByUserId(id);
	}
	@GetMapping("/product/{id}")
	public List<Shelf> getAllUsersByProductId(@PathVariable("id")Integer id){
		return this.shelfRepo.getAllShelfsByProductId(id);
	}
	
	@GetMapping("/all")
	public List<Shelf> getAllShelf(){
		return this.shelfRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Shelf> getShelfById(@PathVariable("id")Integer id) {
		return this.shelfRepo.findById(id);
	}
	
	@PostMapping("/")
	public Shelf saveShelfRecord(@RequestBody Shelf shelf) {
		return this.shelfRepo.save(shelf);
	}
	
	@PostMapping("/all")
	public String saveAllShelf(@RequestBody List<Shelf> shelf) {
		if(shelf.get(0)!=null) {
			this.shelfRepo.saveAll(shelf);
			return "SHELFs SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PutMapping("/")
	public String updateShelf(@RequestBody Shelf shelf) {
		if(this.shelfRepo.existsById(shelf.getS_id())) {
			this.shelfRepo.save(shelf);
			return "SHELF UPDATED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@DeleteMapping("/{id}")
	public String deleteShelf(@PathVariable("id")Integer id) {
		if(this.shelfRepo.existsById(id)) {
			this.shelfRepo.deleteById(id);
			return "SHELF DELETED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	

	
//	//========================================MY Queries=================================
//	
//		@GetMapping("/shelf/user/{id}")
//		public Optional<List<Shelf>> getShelfByUserId(@PathVariable("id")Integer id){
//			
//			List<Shelf> shelfs =  this.getAllShelf();
//			List<Shelf> shelfs2 = new ArrayList<Shelf>();
//			shelfs.stream().filter( (s) -> s.getUser().getU_id()==id).forEach( s -> shelfs2.add(s));
//			
//			System.out.println(shelfs);
//			System.out.println(shelfs2);
//			
//			return Optional.ofNullable(shelfs2);
//		}
	

	
//==============MODIFIED - 18Sept-2021
//	@PostMapping("/")
//	public String saveShelf(@RequestBody Shelf shelf) {
//		if(shelf!=null) {
//			System.out.println("\n\n =========================================================="+shelf+" \n\n");
//			
//			if(shelf.getUser()!=null && userRepo.existsById(shelf.getUser().getU_id()))
//				shelf.setUser(userRepo.getById(shelf.getUser().getU_id()));
//			
//			shelf.getProducts()
//				.forEach( (prod) -> {
//					if(prod!=null && prodRepo.existsById(prod.getProd_id()))
//							prod=prodRepo.getById(prod.getProd_id());
//				});
//			
//				
//			
//			this.shelfRepo.save(shelf);
//			return "SHELF SAVED SUCCESSFULLY";
//		}
//		
//		return "FAILED..!! PLEASE TRY AGAIN";
//	}
	
	
//	@PostMapping("/shelf")
//	public String saveShelf(@RequestBody Shelf shelf) {
//		if(shelf!=null) {
//			System.out.println("\n\n =========================================================="+shelf+" \n\n");
//			
//			if(shelf.getUser()!=null && userRepo.existsById(shelf.getUser().getU_id()))
//				shelf.setUser(userRepo.getById(shelf.getUser().getU_id()));
//			
//			if(shelf.getProduct()!=null && prodRepo.existsById(shelf.getProduct().getP_id()))
//				shelf.setProduct(prodRepo.getById(shelf.getProduct().getP_id()));
//			
//			this.shelfRepo.save(shelf);
//			return "SHELF SAVED SUCCESSFULLY";
//		}
//		
//		return "FAILED..!! PLEASE TRY AGAIN";
//	}
	
	
	/*
	 @PostMapping("/shelf")
	public String saveShelf(@RequestBody Shelf shelf) {
		if(shelf!=null) {
			System.out.println("\n\n =========================================================="+shelf+" \n\n");
			
			if(shelf.getUser()!=null && userRepo.existsById(shelf.getUser().getU_id()))
				shelf.setUser(userRepo.getById(shelf.getUser().getU_id()));
			
			shelf.getProducts().forEach(prod -> {
				if(prod!=null && prodRepo.existsById(prod.getP_id()))
						prod=prodRepo.getById(prod.getP_id());
			});
			
				
			
			this.shelfRepo.save(shelf);
			return "SHELF SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
