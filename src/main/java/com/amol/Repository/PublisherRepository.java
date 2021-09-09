package com.amol.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amol.Entity.Account;
import com.amol.Entity.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer>{

	@Query("SELECET p.account FROM Publisher p WHERE p.pub_id=?1")
	public Account getAccountByProdId(Integer pub_id);
	
}
