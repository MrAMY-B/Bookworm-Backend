package com.amol.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amol.Entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
	@Query("SELECT t FROM Transaction t WHERE t.user.u_id=?1")
	List<Transaction> getAllTransactionsByUserId(Integer id);

//	@Query("SELECT t FROM Transaction t WHERE t.products p where")
//	List<Transaction> findTransactionByProductId(Integer id);

}
