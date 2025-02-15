package com.tasks.taskmanager.service;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

import org.springframework.test.context.ActiveProfiles;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import com.tasks.taskmanager.model.Task;
import com.tasks.taskmanager.repository.TaskRepository;
import com.tasks.taskmanager.service.TaskService;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    public void TaskService_GetTaskById_ReturnFoundTask() {
        Task task = new Task(); task.setTitle("test-task"); task.setId(1L);
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Task foundTask = taskService.getTaskById(1L);

        assertThat(foundTask).isEqualTo(task);
    }

    @Test
    public void TaskService_GetTasksForToday_ReturnTasksForToday() {
        LocalDate today = LocalDate.now();
        List<Task> tasksForToday = new ArrayList<Task>();
        Task task1 = new Task(); task1.setId(1L); task1.setCreatedAt(today);
        Task task2 = new Task(); task2.setId(2L); task2.setCreatedAt(today);
        tasksForToday.add(task1);
        tasksForToday.add(task2);
        when(taskRepository.findByCreatedAt(today)).thenReturn(tasksForToday);
        
        taskService.createTask(task1);
        taskService.createTask(task2);
        List<Task> foundTasksForToday = taskService.getTasksForToday(null);

        assertThat(foundTasksForToday.size()).isEqualTo(2);
    }

    @Test
    public void TaskService_GetUncompletedTasksForToday_ReturnUncompletedTasksForToday() {
        LocalDate today = LocalDate.now();
        List<Task> uncompletedTasks = new ArrayList<Task>();
        Task task1 = new Task(); task1.setId(1L); task1.setCreatedAt(today);
        Task task2 = new Task(); task2.setId(2L); task2.setCreatedAt(today);
        task1.setCompleted(false);
        task1.setCompleted(true);
        uncompletedTasks.add(task1);
        when(taskRepository.findByCreatedAtAndCompleted(today, false)).thenReturn(uncompletedTasks);

        taskService.createTask(task1);
        taskService.createTask(task2);
        List<Task> foundUncompletedTasks = taskService.getTasksForToday(false);

        assertThat(foundUncompletedTasks.get(0)).isEqualTo(task1);
    }
}
