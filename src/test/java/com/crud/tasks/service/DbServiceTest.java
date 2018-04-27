package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTest {

    @InjectMocks
    DbService dbService;

    @Mock
    TaskRepository taskRepository;

    @Test
    public void getAllTasks() {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L,"title", "content"));

        when(taskRepository.findAll()).thenReturn(taskList);

        //When
        List<Task> fetchedTaskList = dbService.getAllTasks();

        //Then
        assertEquals(1, fetchedTaskList.size());
    }

    @Test
    public void getTask() {
        //Given
        Task task = new Task(1L,"title", "content");

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        //When
        Optional<Task> fetchedTask = dbService.getTask(1L);

        //Then
        assertEquals(1, fetchedTask.get().getId().longValue());
    }

    @Test
    public void saveTask() {
        //Given
        Task task = new Task(1L,"title", "content");
        when(taskRepository.save(task)).thenReturn(task);

        //When
        Task savedTask = dbService.saveTask(task);

        //Then
        assertEquals(1L, savedTask.getId().longValue());
        assertEquals("title", savedTask.getTitle());
        assertEquals("content", savedTask.getContent());
    }
}