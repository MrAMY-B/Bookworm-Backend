package com.amol.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer acc_id;
	private String bank_name;
	private String branch;
	private String ifsc;
	private Integer acc_number;
	private String acc_type;
	private String pan_no;
	
	
}
