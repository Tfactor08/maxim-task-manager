package com.tasks.taskmanager.repository;

import com.tasks.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.time.LocalDate;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCreatedAt(LocalDate date);
    List<Task> findByCreatedAtAndCompleted(LocalDate date, boolean completed);
    List<Task> findByCreatedAtBetween(LocalDate startDate, LocalDate endDate);
    List<Task> findByCreatedAtBetweenAndCompleted(LocalDate startDate, LocalDate endDate, boolean completed);
}
