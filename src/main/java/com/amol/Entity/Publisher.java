package com.amol.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Publisher {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pub_id;
	private String name;
	private String email;
	private String mobile;
	
	@OneToMany(mappedBy = "publisher",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonBackReference
	private List<Product> prouct;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "add_id")
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "acc_id")
	@JsonIgnore
	private Account account;
	
}
