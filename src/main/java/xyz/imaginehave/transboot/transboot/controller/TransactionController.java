package xyz.imaginehave.transboot.transboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import xyz.imaginehave.transboot.transboot.entity.Transaction;
import xyz.imaginehave.transboot.transboot.repository.TransactionRepository;

@RestController
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;
	
    @GetMapping("/tranactions")
    public Page<Transaction> getTransactions(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }
    
    @PostMapping("/tranaction")
    public Transaction createTransaction(@Valid @RequestBody Transaction transaction) {
        return transactionRepository.save(transaction);
    } 
        
}
