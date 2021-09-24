package com.amol.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibPackTrans {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lpt_id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private LibraryPackage lib_pack;
	
	private Date date;
	
	
	
}
