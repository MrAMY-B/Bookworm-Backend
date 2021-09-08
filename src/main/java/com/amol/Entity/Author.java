package com.amol.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer auth_id;
	
	private String name;
	private String email;
	private String mobile;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "add_id")
	private Address address;
	
	private Boolean has_beneficiary;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ban_id")
	@JsonBackReference
	private Beneficiary beneficiary;
	
	@OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
	@JoinColumn(name = "acc_id")
	@JsonBackReference
	private Account account;
	
	
	@ManyToMany(mappedBy ="authors",fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Product> products=new ArrayList<>();
//-------------- WORKING GOOD---------------------

	
	
	
	
	
	
	
	
	
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "prod_id",referencedColumnName = "p_id")
//	private Product product;
	
	
	
	 
	

}

