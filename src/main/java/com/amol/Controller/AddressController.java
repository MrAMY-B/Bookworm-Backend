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

import com.amol.Entity.Address;
import com.amol.Repository.AddressRepository;

@RestController
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressRepository addRepo;
	
	@GetMapping("/all")
	public List<Address> getAllAddress(){
		return this.addRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Address> getAddressById(@PathVariable("id")Integer id) {
		System.out.println("\naaaaa\n"+this.addRepo.findById(id));
		return this.addRepo.findById(id);
	}
	
	
	@PostMapping("/")
	public String saveAddress(@RequestBody Address address) {
		if(address!=null) {
			this.addRepo.save(address);
			return "ADDRESS SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PostMapping("/all")
	public String saveAllAddress(@RequestBody List<Address> address) {
		if(address.get(0)!=null) {
			this.addRepo.saveAll(address);
			return "ADDRESSs SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PutMapping("/")
	public String updateAddress(@RequestBody Address address) {
		if(this.addRepo.existsById(address.getAdd_id())) {
			this.addRepo.save(address);
			return "ADDRESS UPDATED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@DeleteMapping("/{id}")
	public String deleteAddress(@PathVariable("id")Integer id) {
		if(this.addRepo.existsById(id)) {
			this.addRepo.deleteById(id);
			return "ADDRESS DELETED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	
	
}
