package com.groupproject.Group.Project.services;

import com.groupproject.Group.Project.models.Customer;
import com.groupproject.Group.Project.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Customer> findById(long id) {
        return customerRepository.findById(id);
    }
    public boolean existsById(Long id) {
        return customerRepository.existsById(id);
    }
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
