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

import com.amol.Entity.Transaction;
import com.amol.Repository.ShelfRepository;
import com.amol.Repository.TransactionRepository;

@RestController
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/trans")
public class TransactionController {

	
	@Autowired
	TransactionRepository transRepo;
	
	@Autowired
	ShelfRepository shelfRepo;
	
	
	@GetMapping("/all")
	public List<Transaction> getAllTransaction(){
		return this.transRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Transaction> getTransactionById(@PathVariable("id")Integer id) {
		System.out.println("\n\n==== ID : "+id);
		return this.transRepo.findById(id);
	}
	
	@GetMapping("/user/{id}")
	public List<Transaction>  getTransactionByUserId(@PathVariable("id")Integer id) {
		return this.transRepo.getAllTransactionsByUserId(id);
		
	}		

	@GetMapping("/product/{id}")
	public List<Transaction> getTransactionByProductId(@PathVariable("id")Integer id) {
		return this.transRepo.findTransactionByProductId(id);
	}
	
	@PostMapping("/")
	public Transaction saveOneTransaction(@RequestBody Transaction tran) {
		return this.transRepo.save(tran);
	}
	
	//==============MODIFIED - 18Sept-2021
//	@PostMapping("/")
//	public String saveTransaction(@RequestBody Transaction trans) {
//		if(trans!=null) {
//			trans.setDate(new Date());
//			Transaction  t = this.transRepo.save(trans);
//			
//			if(t!=null && t.getTr_id()>0 ) {
//				Shelf shelf = new Shelf();
//				
//				t.getProducts()
//					.forEach( prod ->{
//						shelf.getProducts().add(prod);
//					});
//				
//				shelf.setUser(t.getUser());
//				shelf.setTr_type(t.getTr_type());
//				shelf.setProd_expiry(new java.sql.Date(System.currentTimeMillis()));
//				
//				Shelf ss = this.shelfRepo.save(shelf);
//				System.out.println("\n\n ========================\n"+ss+" \n\n");
//			}
//			return "TRANSACTION SAVED SUCCESSFULLY";
//		}
//		return "FAILED..!! PLEASE TRY AGAIN";
//	}
	
	@PostMapping("/all")
	public String saveAllTransaction(@RequestBody List<Transaction> trans) {
		if(trans.get(0)!=null) {
			this.transRepo.saveAll(trans);
			return "TRANSACTIONs SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PutMapping("/")
	public String updateTransaction(@RequestBody Transaction trans) {
		if(this.transRepo.existsById(trans.getTr_id())) {
			this.transRepo.save(trans);
			return "TRANSACTION UPDATED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@DeleteMapping("/{id}")
	public String deleteTransaction(@PathVariable("id")Integer id) {
		if(this.transRepo.existsById(id)) {
			this.transRepo.deleteById(id);
			return "TRANSACTION DELETED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}





}

	

