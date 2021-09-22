package com.amol.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.amol.Entity.ProductFiles;
import com.amol.Repository.ProductRepository;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class UploadFileController {


	@Autowired
	ProductFiles prodFile;
	
	@Autowired
	ProductRepository prodRepo;
	
	
	@PostMapping("/update-file-paths/{id}")
	public void updateProductImageAndProductFile(@RequestParam("image")String image,
												@RequestParam("file") String file,
												@PathVariable("id")Integer prod_id) {
		this.prodRepo.updateProductImageAndProductFile(image, file, prod_id);
	};
	
	
	@PostMapping(value = "/upload-files/{id}")
	public List<String> uploadFiles(@RequestParam("file") MultipartFile file,
									@RequestParam("image") MultipartFile image,
									@PathVariable("id")Integer prod_id
			) throws IOException{
		
		
		
		List<String> filesPath = new ArrayList<String>();
		Boolean isFileUploaded =false,
				isImageUpLoaded=false;
		
		if(!image.isEmpty()) {
			if(prodFile.uploadImage(image)) {
				isImageUpLoaded=true; filesPath.add("Image Found");
				System.out.println(image.getOriginalFilename()+" | "+image.getContentType());
				filesPath.add(
						ServletUriComponentsBuilder
						.fromCurrentContextPath()
						.path("/products/images/")
						.path(image.getOriginalFilename()).toUriString());
			}
		}
		
		if(!file.isEmpty()) {
			if(prodFile.uploadFile(file)) {
				isFileUploaded=true; filesPath.add("File Found");
				filesPath.add(
						ServletUriComponentsBuilder
						.fromCurrentContextPath()
						.path("/products/files/")
						.path(file.getOriginalFilename()).toUriString());
			}
		}
		
		if(isImageUpLoaded && isFileUploaded)
			this.prodRepo.updateProductImageAndProductFile(filesPath.get(3), filesPath.get(1), prod_id);
			
		
		if(filesPath.size()>0)
			return filesPath;
		
		
		
		return null;
	}
	
}
