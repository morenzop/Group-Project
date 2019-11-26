package com.groupproject.Group.Project.controllers;

import com.groupproject.Group.Project.models.Response;
import com.groupproject.Group.Project.models.Withdrawal;
import com.groupproject.Group.Project.services.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class WithdrawalController {
    @Autowired
    private WithdrawalService withdrawalService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/withdrawals/{id}")
    public ResponseEntity<?> getWithdrawalById(@PathVariable long id){
        Optional<Withdrawal> d = withdrawalService.findById(id);
        Response response = new Response();
        response.setCode(200);
        response.setData(new ArrayList<>(Collections.singleton(d)));
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @GetMapping("/accounts/{id}/withdrawals")
    public ResponseEntity<?> getWithdrawalsForAccount(@PathVariable String id){
        List<Withdrawal> d = withdrawalService.findAllByAccountId(id);
        Response response = new Response();
        response.setCode(200);
        response.setData(d);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/accounts/{id}/withdrawals")
    public ResponseEntity<?> createWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable String id) {
        Response response = new Response();
        HttpStatus statusCode;
        if (!accountService.existsById(Long.parseLong(id))) {
            response.setCode(404);
            response.setMessage("Error creating withdrawal: Account not found.");
            statusCode = HttpStatus.NOT_FOUND;
        } else {
            response.setCode(201);
            Withdrawal submit = withdrawalService.createWithdrawal(withdrawal, id);
            response.setData(new ArrayList<>(Collections.singleton(submit)));
            statusCode = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(response, statusCode);
    }

    @PutMapping("/withdrawals/{id}")
    public ResponseEntity<?> updateWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable Long id) {
        withdrawalService.updateWithdrawal(withdrawal, id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/withdrawals/{id}")
    public ResponseEntity<?> deleteWithdrawal(@PathVariable Long id) {
        withdrawalService.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
