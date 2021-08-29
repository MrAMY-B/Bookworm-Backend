package com.amol.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amol.Entity.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
