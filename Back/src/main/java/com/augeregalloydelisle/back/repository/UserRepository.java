package com.augeregalloydelisle.back.repository;

import java.util.Optional;

import com.augeregalloydelisle.back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Integer>
{
    Optional<User> findByUsername(String userName);
    
}
