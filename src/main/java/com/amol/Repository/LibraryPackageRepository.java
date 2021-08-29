package com.amol.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amol.Entity.LibraryPackage;

@Repository
public interface LibraryPackageRepository extends JpaRepository<LibraryPackage, Integer> {

}
