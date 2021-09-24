package com.amol.Controller;

import java.sql.Date;
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

import com.amol.Entity.LibPackTrans;
import com.amol.Entity.LibraryPackage;
import com.amol.Entity.User;
import com.amol.Repository.LibPackTransRepository;
import com.amol.Repository.LibraryPackageRepository;
import com.amol.Repository.UserRepository;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/pack-tx")
public class LibPackTransController {

	@Autowired
	LibPackTransRepository packRepo;
	
	@Autowired
	LibraryPackageRepository lppRepo;
	
	@Autowired
	UserRepository uRepo;
	
	@GetMapping("/all")
	public List<LibPackTrans> getAllLibPackTrans(){
		return this.packRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public LibPackTrans getLibPackTransById(@PathVariable("id")Integer id) {
		
		return this.packRepo.getById(id);
	}
	
	
	/*
	 * libPack = this.packRepo.save(libPack);
			User  u = libPack.getUser();
			LibraryPackage lp = libraryPackageRepository.getById(libPack.getLib_pack().getPack_id());
			u.setCan_lent_product(u.getCan_lent_product()+lp.getNo_prod());
			uRepo.save(u);
	 */
	
	@PostMapping("/")
	public String saveLibPackTrans(@RequestBody LibPackTrans libPack) {
		if(libPack!=null) {
			libPack.setDate(new Date(System.currentTimeMillis()));
			libPack = this.packRepo.save(libPack);
			User  u = this.uRepo.getById(libPack.getUser().getU_id()); 
			
			LibraryPackage lp = this.lppRepo.getById(libPack.getLib_pack().getPack_id());
			u.setCan_lent_product(u.getCan_lent_product()+lp.getNo_prod());
			uRepo.save(u);
			
			return "LIB_PACK_TRANS SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PostMapping("/all")
	public String saveAllLibPackTrans(@RequestBody List<LibPackTrans> libPack) {
		if(libPack.get(0)!=null) {
			this.packRepo.saveAll(libPack);
			return "LIBRARY-PACKAGEs SAVED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@PutMapping("/")
	public String updateLibPackTrans(@RequestBody LibPackTrans libPack) {
		if(this.packRepo.existsById(libPack.getLpt_id())) {
			this.packRepo.save(libPack);
			return "LIBRARY-PACKAGE UPDATED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	@DeleteMapping("/{id}")
	public String deleteLibPackTrans(@PathVariable("id")Integer id) {
		if(this.packRepo.existsById(id)) {
			this.packRepo.deleteById(id);
			return "LIBRARY-PACKAGE DELETED SUCCESSFULLY";
		}
		
		return "FAILED..!! PLEASE TRY AGAIN";
	}
	
	
	
	
}
