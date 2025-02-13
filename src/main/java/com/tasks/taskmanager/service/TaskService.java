package com.tasks.taskmanager.service;

import com.tasks.taskmanager.model.Task;
import com.tasks.taskmanager.repository.TaskRepository;
import com.tasks.taskmanager.exception.TaskNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
            .orElseThrow(() -> new TaskNotFoundException("Taks not found with id: " + id));
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task taskDetails) {
        Task task = getTaskById(id);
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setCompleted(taskDetails.getCompleted());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksForToday(Boolean completed) {
        LocalDate today = LocalDate.now();
        if (completed != null) {
            return taskRepository.findByCreatedAtAndCompleted(today, completed);
        } else {
            return taskRepository.findByCreatedAt(today);
        }
    }

    public List<Task> getTasksForThisWeek(Boolean completed) {
        LocalDate startOfWeek = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate endOfWeek = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        if (completed != null) {
            return taskRepository.findByCreatedAtBetweenAndCompleted(startOfWeek, endOfWeek, completed);
        } else {
            return taskRepository.findByCreatedAtBetween(startOfWeek, endOfWeek);
        }
    }

    public List<Task> getTasksForThisMonth(Boolean completed) {
        LocalDate startOfMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDate endOfMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        if (completed != null) {
            return taskRepository.findByCreatedAtBetweenAndCompleted(startOfMonth, endOfMonth, completed);
        } else {
            return taskRepository.findByCreatedAtBetween(startOfMonth, endOfMonth);
        }
    }
}
