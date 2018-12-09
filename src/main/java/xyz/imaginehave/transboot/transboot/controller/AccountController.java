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
        return accountRepository.save(account);
    } 
    
    @PostMapping("/testAccount")
    public Account test() {
    	
    	TransectUser user = new TransectUser();
    	user.setId(new TransectUserId("foo","foo@bar.com"));
    	user.setPassword("password");
    	
    	userRepository.save(user);
    	
    	Account account = new Account();
    	account.setUser(user);
    	
    	System.out.println(account);
    	
    	return accountRepository.save(account);
    } 
    
}
