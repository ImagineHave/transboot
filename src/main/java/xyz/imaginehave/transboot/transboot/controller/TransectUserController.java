package xyz.imaginehave.transboot.transboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import xyz.imaginehave.transboot.transboot.entity.TransectUser;
import xyz.imaginehave.transboot.transboot.repository.TransectUserRepository;

@RestController
@RequestMapping("/users")
public class TransectUserController {

    @Autowired
    private TransectUserRepository transectUserRepository;
	
    @GetMapping("/list")
    public Page<TransectUser> getUsers(Pageable pageable) {
        return transectUserRepository.findAll(pageable);
    }
    
    @PostMapping("/create")
    public TransectUser createUser(@Valid @RequestBody TransectUser user) {
        return transectUserRepository.save(user);
    } 
        
}
