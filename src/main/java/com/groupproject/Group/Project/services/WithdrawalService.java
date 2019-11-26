package com.groupproject.Group.Project.services;


import com.groupproject.Group.Project.models.Withdrawal;
import com.groupproject.Group.Project.repositories.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class WithdrawalService {
    @Autowired
    private WithdrawalRepository withdrawalsRepository;

    public List<Withdrawal> findAllByAccountId(String id){
        return withdrawalsRepository.findAllByPayerId(id);
    }

    public Optional<Withdrawal> findById(long id) {
        return withdrawalsRepository.findById(id);
    }

    public void updateWithdrawal(Withdrawal withdrawal, long id) {
        Withdrawal withdrawalToUpdate = withdrawalsRepository.getOne(id);
        if (withdrawal.getType() != null) withdrawalToUpdate.setType(withdrawal.getType());
        if (withdrawal.getAmount() != null) withdrawalToUpdate.setAmount(withdrawal.getAmount());
        if (withdrawal.getTransaction_date() != null) withdrawalToUpdate.setTransaction_date(withdrawal.getTransaction_date());
        if (withdrawal.getStatus() != null) withdrawalToUpdate.setStatus(withdrawal.getStatus());
        if (withdrawal.getMedium() != null) withdrawalToUpdate.setMedium(withdrawal.getMedium());
        if (withdrawal.getDescription() != null) withdrawalToUpdate.setDescription(withdrawal.getDescription());
        withdrawalsRepository.save(withdrawalToUpdate);
    }

    public void deleteById(Long id) {
        withdrawalsRepository.deleteById(id);
    }

    public Withdrawal createWithdrawal(Withdrawal withdrawal, String id) {
        Withdrawal submit = new Withdrawal();
        submit.setAmount(withdrawal.getAmount());
        submit.setDescription(withdrawal.getDescription());
        submit.setId(withdrawal.getId());
        submit.setMedium(withdrawal.getMedium());
        submit.setTransaction_date(withdrawal.getTransaction_date());
        submit.setType(withdrawal.getType());
        submit.setStatus(withdrawal.getStatus());
        submit.setPayerId(id);
        withdrawalsRepository.save(submit);
        return submit;
    }
}
