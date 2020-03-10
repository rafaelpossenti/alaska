package com.possenti.alaska.user;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Rafael Possenti
 * @since 2020-02-25
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
