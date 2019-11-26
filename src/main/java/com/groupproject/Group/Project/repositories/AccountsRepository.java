package com.groupproject.Group.Project.repositories;

import com.groupproject.Group.Project.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountsRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByCustomerId(Long customerId);

    List<Account> findAccountsByCustomerId(Long id);

}
