package com.amol.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LibraryPackage {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pack_id;
	private Integer duration;
	private Integer amount;
	private Integer no_prod;
	
	
	
	
}
