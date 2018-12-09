package xyz.imaginehave.transboot.transboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import xyz.imaginehave.transboot.transboot.entity.Account;
import xyz.imaginehave.transboot.transboot.entity.TransectUser;
import xyz.imaginehave.transboot.transboot.entity.TransectUser.TransectUserId;
import xyz.imaginehave.transboot.transboot.repository.AccountRepository;
import xyz.imaginehave.transboot.transboot.repository.TransectUserRepository;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransectUserRepository userRepository;
	
    @GetMapping("/accounts")
    public Page<Account> getAccounts(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }
    
    @PostMapping("/accounts")
    public Account createAccount(@Valid @RequestBody Account account) {
    	
    	System.out.println(account);
    	
        return accountRepository.save(account);
    } 
    
    @PostMapping("/testAccount")
    public Account test() {
    	
    	TransectUser transectUser = new TransectUser();
    	transectUser.setId(new TransectUserId("foo","foo@bar.com"));
    	transectUser.setPassword("password");
    	
    	userRepository.save(transectUser);
    	
    	Account account = new Account();
    	account.setTransectUser(transectUser);
    	
    	System.out.println(account);
    	
    	return accountRepository.save(account);
    } 
    
}
