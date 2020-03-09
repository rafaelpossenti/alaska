package com.possenti.alaska.goal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rafael Possenti
 * @since 2020-03-09
 */
@Service
public class GoalService {

    private final GoalRepository repository;

    @Autowired
    public GoalService(final GoalRepository repository) {
        this.repository = repository;
    }

    public List<Goal> list() {
        return repository.findAll();
    }

    public void save(final Goal goal) {
        repository.save(goal);
    }

}
