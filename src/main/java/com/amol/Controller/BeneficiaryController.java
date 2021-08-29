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

import com.amol.Entity.Beneficiary;
import com.amol.Repository.BeneficiaryRepository;

@RestController
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/beneficiary")
public class BeneficiaryController {

	@Autowired
	BeneficiaryRepository banRepo;
	
	@GetMapping("/all")
	public List<Beneficiary> getAllBeneficiary(){
		return this.banRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Beneficiary> getBeneficiaryById(@PathVariable("id")Integer id) {
		System.out.println("\naaaaa\n"+this.banRepo.findById(id));
		return this.banRepo.findById(id);
	}
	
	
	@PostMapping("/")
	public String saveBeneficiary(@RequestBody Beneficiary beneficiary) {
		if(beneficiary!=null) {
			this.banRepo.save(beneficiary);
			return "BENEFICIARY SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PostMapping("/all")
	public String saveAllBeneficiary(@RequestBody List<Beneficiary> beneficiary) {
		if(beneficiary.get(0)!=null) {
			this.banRepo.saveAll(beneficiary);
			return "BENEFICIARYs SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PutMapping("/")
	public String updateBeneficiary(@RequestBody Beneficiary beneficiary) {
		if(this.banRepo.existsById(beneficiary.getBan_id())) {
			this.banRepo.save(beneficiary);
			return "BENEFICIARY UPDATED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@DeleteMapping("/{id}")
	public String deleteBeneficiary(@PathVariable("id")Integer id) {
		if(this.banRepo.existsById(id)) {
			this.banRepo.deleteById(id);
			return "BENEFICIARY DELETED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	
	
}
