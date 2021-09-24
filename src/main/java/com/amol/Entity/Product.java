package com.amol.Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prod_id;
	private String isbn;
	private String title;
	private String title_in_english;
	
	


	@ManyToOne	
	@JoinColumn(name = "gen_id")
	private Genre genre;
	
	
	@ManyToMany( cascade = CascadeType.ALL)
	@JoinTable(name = "prod_auth", 
		joinColumns = @JoinColumn(name="prod_id"), 
		inverseJoinColumns = @JoinColumn(name="auth_id"))
	private List<Author> authors=new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "pub_id")
	private Publisher publisher;
	
	private Double base_price;
	private Double sale_price;
	private Double offer_price;
	
	private Date avl_date;
	
	private String short_desc;
	private String long_desc;
	private String front_image_link;
	private String product_link;
	
	private Boolean is_rentable;
	private Boolean is_library;
	private Float length;
	
	
	
	
	
//	@ManyToMany(mappedBy = "products")
//	@JsonBackReference
//	private List<Transaction> transactions;


}








