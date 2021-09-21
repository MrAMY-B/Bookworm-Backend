package com.amol.Entity;




import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Integer tr_id;
	
//	@ManyToMany(fetch = FetchType.EAGER )
//	@JoinTable(name = "tansactions_products",
//			joinColumns = @JoinColumn(name="tr_id"),
//			inverseJoinColumns = @JoinColumn(name="prod_id")
//			)
//	private List<Product> products=new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "prod_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "u_id")
	private User user;
	
	
	private String tr_type;
	

	private Date date;
	
	private Double amt;
	
	
	private String status;
	
	
	
	
}
