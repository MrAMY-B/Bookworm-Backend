package com.amol.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer f_id;
	private String name;
	private String email;
	private String query;
	

	

	

}
