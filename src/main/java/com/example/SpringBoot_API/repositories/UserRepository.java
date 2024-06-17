package com.example.SpringBoot_API.repositories;

import com.example.SpringBoot_API.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
