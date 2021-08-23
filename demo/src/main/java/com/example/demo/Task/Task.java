package com.example.demo.Task;

import javax.persistence.*;

@Entity
@Table
public class Task {
    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private Long id;
    private Long userId;
    private String description;

    public Task() {
    }

    public Task(Long id, Long userId, String description) {
        this.id = id;
        this.userId = userId;
        this.description = description;
    }

    public Task(Long userId, String description) {
        this.userId = userId;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long toDoListId) {
        this.userId = toDoListId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", userId=" + userId +
                ", description='" + description + '\'' +
                '}';
    }
}
