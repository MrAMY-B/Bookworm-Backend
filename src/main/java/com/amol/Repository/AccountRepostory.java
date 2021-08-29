package com.amol.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amol.Entity.Account;

@Repository
public interface AccountRepostory extends JpaRepository<Account, Integer> {

}
