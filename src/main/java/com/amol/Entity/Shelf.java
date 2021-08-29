package com.amol.Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Shelf {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer s_id;
	
	@ManyToOne
	private User user;
	
	@ManyToMany
	@JoinTable(name = "shelf_products",
				joinColumns = @JoinColumn(name="s_id"),
				inverseJoinColumns = @JoinColumn(name="prod_id"))
	private List<Product> products=new ArrayList<>();
	
//	@OneToMany
//	private List<Product> products;
//	
	
	
	private String tr_type;
	
	
	private Date prod_expiry;
	
}
	
