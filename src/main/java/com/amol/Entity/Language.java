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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Language {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lang_id;
	private String language;
	

	@ManyToOne 
	@JoinColumn(name="cate_id")
	private Category category;
	
	@OneToMany(mappedBy = "language")	
	@JsonIgnore
	private List<Genre> genres;
	
	
	
	
}
