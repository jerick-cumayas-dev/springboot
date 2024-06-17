package com.example.SpringBoot_API.controllers;

import com.example.SpringBoot_API.models.User;
import com.example.SpringBoot_API.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/api/users"})
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
    }

    @GetMapping
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = this.userService.getUserById(id);
        return (ResponseEntity)user.map(ResponseEntity::ok).orElseGet(() -> {
            return ResponseEntity.notFound().build();
        });
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return this.userService.createUser(user);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        Optional<User> user = this.userService.getUserById(id);
        if (user.isPresent()) {
            User updatedUser = (User)user.get();
            updatedUser.setFirstName(userDetails.getFirstName());
            updatedUser.setMiddleName(userDetails.getMiddleName());
            updatedUser.setLastName(userDetails.getLastName());
            return ResponseEntity.ok(this.userService.createUser(updatedUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
