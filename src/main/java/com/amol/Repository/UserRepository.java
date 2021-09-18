package com.amol.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amol.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	@Query("SELECT u.pass FROM User u")
	List<String> getAllPasswords();

}
