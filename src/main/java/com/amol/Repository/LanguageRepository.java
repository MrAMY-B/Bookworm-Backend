package com.amol.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amol.Entity.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer>{

}
