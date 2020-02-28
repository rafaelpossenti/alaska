package com.possenti.alaska.userprofile;


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
@RequestMapping("/api/v1")
public class UserProfileController {

    @Autowired
    private UserProfileRepository repository;

    @Autowired
    private UserProfileValidator userProfileValidator;

    @GetMapping("/user-profiles")
    List<UserProfile> list() {
        return repository.findAll();
    }

    @PostMapping("/user-profiles")
    public void insert(@RequestBody @Valid UserProfile user) {
        this.repository.save(user);
    }

    @InitBinder("userProfile")
    public void setupBinder(WebDataBinder binder) {
        binder.addValidators(userProfileValidator);
    }
}
