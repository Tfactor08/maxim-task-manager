package com.tasks.taskmanager.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import com.tasks.taskmanager.model.Task;
import com.tasks.taskmanager.repository.TaskRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@ActiveProfiles("test")
public class TaskRepositoryTest {
    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void TaskRepository_FindByCreatedAt_ReturnFoundTask() {
        Task task = new Task(); task.setTitle("task1");
        LocalDate now = LocalDate.now();

        taskRepository.save(task);
        Task foundTasks = taskRepository.findByCreatedAt(now).get(0);

        Assertions.assertThat(foundTasks).isEqualTo(task);
    }
}
