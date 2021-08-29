package com.amol.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amol.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
