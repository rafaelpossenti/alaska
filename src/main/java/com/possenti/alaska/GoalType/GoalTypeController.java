package com.possenti.alaska.GoalType;


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
public class GoalTypeController {

    @Autowired
    private GoalTypeRepository repository;

    @GetMapping("/goal-types")
    ResponseEntity<List<GoalType>> list() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/goal-types")
    public void insert(@RequestBody @Valid GoalType goalType) {
        this.repository.save(goalType);
    }
}
