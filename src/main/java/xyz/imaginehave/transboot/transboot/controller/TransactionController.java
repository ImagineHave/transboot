package xyz.imaginehave.transboot.transboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import xyz.imaginehave.transboot.transboot.entity.Transaction;
import xyz.imaginehave.transboot.transboot.repository.TransactionRepository;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;
	
    @GetMapping("/list")
    public Page<Transaction> getTransactions(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }
    
    @PostMapping("/create")
    public Transaction createTransaction(@Valid @RequestBody Transaction transaction) {
    	System.out.println(transaction);
        return transactionRepository.save(transaction);
    } 
        
}
