package com.amol.Entity;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductFiles {

	private Integer u_id;
	private MultipartFile image;
	private MultipartFile file;
		
	public boolean uploadImage(MultipartFile image) {
		try {
			
			String filePath = new ClassPathResource("static/products/images").getFile().getAbsolutePath();
			Files.copy(image.getInputStream(), 
						Paths.get(filePath+File.separator+image.getOriginalFilename()), 
						StandardCopyOption.REPLACE_EXISTING);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public  boolean uploadFile(MultipartFile file) {
		try {
			String filePath = new ClassPathResource("/static/products/files").getFile().getAbsolutePath();
				Files.copy(file.getInputStream(), 
							Paths.get(filePath+File.separator+file.getOriginalFilename()), 
							StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
