package com.amol.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amol.Entity.Account;
import com.amol.Entity.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	
	@Query("SELECT a.account FROM Author a WHERE a.auth_id=?1")
	public Account getAccountByAuthId(Integer auth_id);
	
}
