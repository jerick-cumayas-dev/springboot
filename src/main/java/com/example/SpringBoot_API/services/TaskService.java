package com.example.SpringBoot_API.services;

import com.example.SpringBoot_API.models.Task;
import com.example.SpringBoot_API.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskService() {

    }

    public List<Task> getAllTasks() {
        return this.taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id){
        return this.taskRepository.findById(id);
    }

    public Task createTask(Task task){
        return (Task)this.taskRepository.save(task);
    }

    public void deleteTask(Long id){
        this.taskRepository.deleteById(id);
    }
}
