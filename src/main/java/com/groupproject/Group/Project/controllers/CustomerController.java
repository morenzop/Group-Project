package com.groupproject.Group.Project.controllers;

import com.groupproject.Group.Project.models.Account;
import com.groupproject.Group.Project.models.Customer;
import com.groupproject.Group.Project.models.Response;
import com.groupproject.Group.Project.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomers(){
        Response response=new Response();
        HttpStatus statusCode;
        List<Customer> c = customerService.findAll();
        response.setCode(200);
        response.setMessage("Success");
        response.setData(c);
        statusCode = HttpStatus.OK;
        return new ResponseEntity<>(response, statusCode);
    }
    @GetMapping("/customers/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable long id) {
        HttpStatus statusCode;
        Response response = new Response();
        Optional<Customer> c = customerService.findById(id);
        if (!c.isPresent()) {
            response.setCode(404);
            response.setMessage("Error fetching account: " + id);
            statusCode = HttpStatus.NOT_FOUND;
        } else {
            response.setCode(200);
            response.setMessage("Success");
            response.setData(new ArrayList<>(Collections.singleton(c.get())));
            statusCode = HttpStatus.OK;
        }
        return new ResponseEntity<>(response, statusCode);
    }
    @PostMapping("/customers")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) throws IOException {
        Response response= new Response();
        response.setCode(201);
        response.setMessage("Customer account created");
        response.setData(new ArrayList<>(Collections.singleton(customer)));
        customerService.save(customer);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PutMapping("/customers/{id}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable("id") long id){
        Response response = new Response();
        HttpStatus statusCode;
        Optional<Customer> g = customerService.findById(id);
        if(!customerService.existsById(id)){
            response.setCode(404);
            response.setMessage("Error");
            statusCode = HttpStatus.NOT_FOUND;
        } else {
            customerService.updateCustomer(customer, id);
            response.setCode(200);
            response.setMessage("Customer account updated");
            response.setData(Collections.singletonList(g));
            statusCode = HttpStatus.OK;
        }
        return new ResponseEntity<>(response, statusCode);
    }
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@RequestBody Customer customer, @PathVariable("id") long id){
        Response response = new Response();
        HttpStatus statusCode;
        if(!customerService.existsById(id)) {
            response.setCode(404);
            response.setMessage("Account does not exists");
            statusCode = HttpStatus.NOT_FOUND;
        }else{
            customerService.deleteById(id);
            response.setCode(202);
            response.setMessage("Customer successfully deleted");
            statusCode = HttpStatus.ACCEPTED;
        }
        return new ResponseEntity<>(response, statusCode);
    }
}
