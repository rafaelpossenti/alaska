package com.possenti.alaska.goal;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Rafael Possenti
 * @since 2020-03-02
 */
public interface GoalRepository extends JpaRepository<Goal, Integer> {

    //TODO
//    @Query(value = "SELECT g.* FROM goal g JOIN goal_users gu ON g.id = gu.goal_id JOIN \"user\" u ON gu.users_id = u.id WHERE u.name =: name", nativeQuery = true)
//    List<Goal> findByUser(@Param("name") final String name);

    @Query(value = "select * from Goal g where g.type_id = ?1", nativeQuery = true)
    List<Goal> findByType(final Integer typeId);

    @Query(value = "select * from Goal g where g.status <> 'CLOSED'", nativeQuery = true)
    @Override
    List<Goal> findAll();
}
