package com.amol.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amol.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	@Query("SELECT u.pass FROM User u")
	List<String> getAllPasswords();
	
	@Query("SELECT u FROM User u WHERE u.email=:email AND u.pass=:pass")
	User authenticateUser(@Param("email")String email, @Param("pass")String pass);

}
