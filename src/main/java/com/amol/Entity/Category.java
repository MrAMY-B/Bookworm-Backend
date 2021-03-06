package com.amol.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cate_id;
	private String category;
	
	
	@OneToMany(mappedBy = "category")
	@JsonIgnore
	private List<Language> languages;
	
}
