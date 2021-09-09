package com.amol.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Genre {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer gen_id;
	private String genre;
	
	@ManyToOne
	@JoinColumn(name = "lang_id")
	private Language language;
	
	@OneToMany(mappedBy = "genre")
	@JsonBackReference
	private List<Product> products;

	
}

