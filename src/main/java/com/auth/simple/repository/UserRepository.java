package com.auth.simple.repository;


import com.auth.simple.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
