package com.example.SpringBoot_API.repositories;

import com.example.SpringBoot_API.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
