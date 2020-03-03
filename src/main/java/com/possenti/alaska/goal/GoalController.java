package com.possenti.alaska.goal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Rafael Possenti
 * @since 2020-03-02
 */
@RestController
public class GoalController {

    @Autowired
    private GoalRepository repository;

    @GetMapping("/goals")
    ResponseEntity<List<Goal>> list() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/goals")
    public void insert(@RequestBody @Valid Goal goal) {
        this.repository.save(goal);
    }
}
