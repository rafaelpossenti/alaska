package com.possenti.alaska.goaltype;


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
@RequestMapping("/goal-types")
public class GoalTypeController {

    @Autowired
    private GoalTypeRepository repository;

    @GetMapping
    ResponseEntity<List<GoalType>> list() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public void insert(@RequestBody @Valid GoalType goalType) {
        this.repository.save(goalType);
    }
}
