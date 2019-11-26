package com.groupproject.Group.Project.repositories;

import com.groupproject.Group.Project.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
