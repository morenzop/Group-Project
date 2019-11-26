package com.groupproject.Group.Project.services;

import com.groupproject.Group.Project.models.Account;
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

    public void updateCustomer(Customer customer, long id) {
        Customer customerToUpdate = customerRepository.getOne(id);
        if (customer.getFirst_name() != null) customerToUpdate.setFirst_name(customer.getFirst_name());
        if (customer.getLast_name() != null) customerToUpdate.setLast_name(customer.getLast_name());
        if (customer.getAddress() != null) customerToUpdate.setAddress(customer.getAddress());
        customerRepository.save(customerToUpdate);
    }
    public void deleteById(long id) {
        customerRepository.deleteById(id);
    }
}
