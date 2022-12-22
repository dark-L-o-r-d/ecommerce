package com.omen.ecommerce.repository;

import com.omen.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findUserByEmail(String email);
}
