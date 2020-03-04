package com.possenti.alaska.goal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Rafael Possenti
 * @since 2020-03-02
 */
@RestController
@RequestMapping("/goals")
public class GoalController {

    @Autowired
    private GoalRepository repository;

    @GetMapping
    ResponseEntity<List<Goal>> list() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public void insert(@RequestBody @Valid Goal goal) {
        this.repository.save(goal);
    }
}
