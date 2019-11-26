package com.groupproject.Group.Project.repositories;

import com.groupproject.Group.Project.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findAccountById(long accountId);
}
