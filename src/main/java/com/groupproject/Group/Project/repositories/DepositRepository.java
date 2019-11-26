package com.groupproject.Group.Project.repositories;

import com.groupproject.Group.Project.models.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepositRepository extends JpaRepository <Deposit,Long> {
    List<Deposit> findAllByPayeeId(String payeeId);
}
