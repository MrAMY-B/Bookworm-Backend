package com.amol.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amol.Entity.Shelf;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf, Integer> {
	
	@Query("SELECT s FROM Shelf s WHERE s.user.u_id=?1")
	public List<Shelf> getAllShelfsByUserId(Integer id);
	
//	@Query("SELECT s FROM Shelf s WHERE s.product.p_id = ?1")
//	List<Shelf> getAllShelfsByProductId(Integer id);

}
