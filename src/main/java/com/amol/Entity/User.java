package com.amol.Entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer u_id;
	private String uname;
	
	private String email;
	private String mobile;
	
	@JsonBackReference
	private String pass;
	private Integer points;
	private Integer can_lent_product;
	private Date pack_expiry;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "add_id")
	private Address address;
	
	
	
	
}
