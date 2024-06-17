package com.example.SpringBoot_API.controllers;

import com.example.SpringBoot_API.models.Task;
import com.example.SpringBoot_API.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.management.DescriptorKey;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    public TaskController(){

    }

    @GetMapping
    public List<Task> getAllTasks(){
        return this.taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Optional<Task> task = this.taskService.getTaskById(id);
        return (ResponseEntity)task.map(ResponseEntity::ok).orElseGet(() -> {
            return ResponseEntity.notFound().build();
        });
    }

    @PostMapping
    public Task createTask(@RequestBody Task taskDetails){
        return this.taskService.createTask(taskDetails);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails){
        Optional<Task> task = this.taskService.getTaskById(id);
        if (task.isPresent()) {
            Task updateTask = (Task) task.get();
            updateTask.setTitle(taskDetails.getTitle());
            updateTask.setDescription(taskDetails.getDescription());
            updateTask.setStatus(taskDetails.getStatus());
            updateTask.setPriority(taskDetails.getPriority());
            updateTask.setDueDate(taskDetails.getDueDate());
            return ResponseEntity.ok(this.taskService.createTask(updateTask));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        this.taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
