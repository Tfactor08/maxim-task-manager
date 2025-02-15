package com.tasks.taskmanager.controller;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import com.tasks.taskmanager.model.Task;
import com.tasks.taskmanager.service.TaskService;

@ExtendWith(MockitoExtension.class)
public class TaskControllerTest {
    @Mock
    private TaskService taskService;

    @InjectMocks
    private TaskController taskController;

    @Test
    public void TaskController_GetAllTasks_ReturnAllTasks() {
        List<Task> tasks = new ArrayList<Task>();
        Task task1 = new Task(); task1.setId(1L);
        Task task2 = new Task(); task2.setId(2L);
        tasks.add(task1);
        tasks.add(task2);
        when(taskService.getAllTasks()).thenReturn(tasks);

        taskService.createTask(task1);
        taskService.createTask(task2);
        List<Task> foundTasks = taskService.getAllTasks();

        assertThat(foundTasks.size()).isEqualTo(2);
    }
}
