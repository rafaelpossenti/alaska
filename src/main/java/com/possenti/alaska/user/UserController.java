package com.possenti.alaska.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Rafael Possenti
 * @since 2020-02-25
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserValidator validator;

    @GetMapping
    List<User> list() {
        return repository.findAll();
    }

    @PostMapping
    public void insert(@RequestBody @Valid User user) {
        this.repository.save(user);
    }

    @InitBinder("user")
    public void setupBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }
}
