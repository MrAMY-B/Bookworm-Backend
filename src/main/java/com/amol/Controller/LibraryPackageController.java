package com.amol.Controller;

import java.util.List;

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

import com.amol.Entity.LibraryPackage;
import com.amol.Repository.LibraryPackageRepository;

@RestController
//@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/lib-pack")
public class LibraryPackageController {

	@Autowired
	LibraryPackageRepository libRepo;
	
	@GetMapping("/all")
	public List<LibraryPackage> getAllLibraryPackage(){
		return this.libRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public LibraryPackage getLibraryPackageById(@PathVariable("id")Integer id) {
		System.out.println("\naaaaa\n"+this.libRepo.getById(id));
		return this.libRepo.getById(id);
	}
	
	
	@PostMapping("/")
	public String saveLibraryPackage(@RequestBody LibraryPackage libPack) {
		if(libPack!=null) {
			this.libRepo.save(libPack);
			return "LIBRARY-PACKAGE SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PostMapping("/all")
	public String saveAllLibraryPackage(@RequestBody List<LibraryPackage> libPack) {
		if(libPack.get(0)!=null) {
			this.libRepo.saveAll(libPack);
			return "LIBRARY-PACKAGEs SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PutMapping("/")
	public String updateLibraryPackage(@RequestBody LibraryPackage libPack) {
		if(this.libRepo.existsById(libPack.getPack_id())) {
			this.libRepo.save(libPack);
			return "LIBRARY-PACKAGE UPDATED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@DeleteMapping("/{id}")
	public String deleteLibraryPackage(@PathVariable("id")Integer id) {
		if(this.libRepo.existsById(id)) {
			this.libRepo.deleteById(id);
			return "LIBRARY-PACKAGE DELETED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	
}
