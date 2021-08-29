package com.amol.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amol.Entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
