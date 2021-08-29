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
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer lang_id;
	private String language;
	
//	@OneToMany
//	@JoinColumn(name = "lang_id", updatable = false,insertable = false)
//	@JsonBackReference
//	private List<Product> product;
	
	
	
	
}
