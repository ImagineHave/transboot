package xyz.imaginehave.transboot.transboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import xyz.imaginehave.transboot.transboot.entity.Account;
import xyz.imaginehave.transboot.transboot.repository.AccountRepository;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
	
    @GetMapping("/list")
    public Page<Account> getAccounts(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }
    
    @PostMapping("/create")
    public Account createAccount(@Valid @RequestBody Account account) {
        return accountRepository.save(account);
    } 
    
    @PostMapping("/bulk_create")
    public void createAccounts(@Valid @RequestBody List<Account> accounts) {
    	for(Account account : accounts) {
    		accountRepository.save(account);
    	}
    }  
   
}
