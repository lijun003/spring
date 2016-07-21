package com.ifox.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import com.ifox.example.domain.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByUsername(String username);

}
