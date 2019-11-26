package com.groupproject.Group.Project.repositories;

import com.groupproject.Group.Project.models.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> {
    List<Withdrawal> findAllByPayerId(String payerId);
}
