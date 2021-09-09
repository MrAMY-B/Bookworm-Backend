package com.amol.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amol.Entity.Account;
import com.amol.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	
//	@Query("SELECT e FROM Employee e JOIN e.address a WHERE a.city = :city")
	@Query("SELECT p FROM Product p JOIN p.authors a where a.auth_id = ?1")
	public List<Product> getAllByAuthorsAuth_id(Integer id);
	
	
	@Query("SELECT p FROM Product p WHERE p.genre.gen_id = ?1")
	List<Product> findAllByGenreId(Integer id);
	
	@Query("SELECT p FROM Product p WHERE p.genre.language.lang_id = ?1")
	List<Product> findAllByLanguageId(Integer id);

	@Query("SELECT p FROM Product p WHERE p.genre.language.category.cate_id = ?1")
	List<Product> findAllByCategoryId(Integer id);
	
	
	
}
