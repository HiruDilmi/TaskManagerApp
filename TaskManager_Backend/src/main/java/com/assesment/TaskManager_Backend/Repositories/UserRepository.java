package com.assesment.TaskManager_Backend.Repositories;

import com.assesment.TaskManager_Backend.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
