package com.amol.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Beneficiary {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ban_id;
	private String name;
	private String email;
	private String mobile;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "add_id")
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "acc_id")
	private Account account;
	
}
