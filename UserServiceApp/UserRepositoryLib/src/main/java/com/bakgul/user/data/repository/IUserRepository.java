package com.bakgul.user.data.repository;

import com.bakgul.user.data.entity.User;
import com.bakgul.user.data.entity.enums.Role;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Lazy
public interface IUserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Iterable<User> findByFirstName(String name);
    void deleteByEmail(String email);
    Iterable<User> findByRole(Role role);
}
