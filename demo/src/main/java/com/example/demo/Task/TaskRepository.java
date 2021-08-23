package com.example.demo.Task;

import com.example.demo.User.UserClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.userId = ?1")
    List<Task> findTaskByUserId(Long userId);

    @Query("SELECT t FROM Task t WHERE t.id = ?1")
    Optional<Task> findTaskById(Long taskId);

}
