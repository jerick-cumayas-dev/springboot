package com.example.SpringBoot_API.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String status;
    private String priority;
    private Date due_date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignedTo;

    public Task(){

    }

    public Long getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getPriority(){
        return this.priority;
    }

    public void setPriority(String priority){
        this.priority = priority;
    }

    public Date getDueDate(){
        return this.due_date;
    }

    public void setDueDate(Date due_date){
        this.due_date = due_date;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }
}
