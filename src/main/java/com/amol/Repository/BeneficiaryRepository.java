package com.amol.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amol.Entity.Beneficiary;



@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer> {

}
