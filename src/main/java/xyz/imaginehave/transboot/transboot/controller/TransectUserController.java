package xyz.imaginehave.transboot.transboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xyz.imaginehave.transboot.transboot.controller.exceptions.TransectUserNotFoundException;
import xyz.imaginehave.transboot.transboot.entity.TransectUser;
import xyz.imaginehave.transboot.transboot.repository.TransectUserRepository;

@RestController
@RequestMapping("/users")
public class TransectUserController {

    @Autowired
    private TransectUserRepository transectUserRepository;
	
    
	@GetMapping("/{id}")
	TransectUser one(@PathVariable Long id) {
		return transectUserRepository.findById(id)
			.orElseThrow(() -> new TransectUserNotFoundException(id));
	}
    
	
    @PostMapping("/")
    TransectUser createUser(@Valid @RequestBody TransectUser user) {
        return transectUserRepository.save(user);
    } 
    
    
	@DeleteMapping("/{id}")
	void deleteEmployee(@PathVariable Long id) {
		transectUserRepository.deleteById(id);
	}
        
}
