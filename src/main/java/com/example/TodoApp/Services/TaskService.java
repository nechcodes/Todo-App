package com.example.TodoApp.Services;

import com.example.TodoApp.Models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    public List<Task> getAllTask();

    public Optional<Task> findTaskById(Long id);

    public List<Task> findAllCompletedTask();

    public List <Task> findAllIncompleteTask();

    public Task createNewTask(Task task);

    public Task updateTask(Task task);

    public void deleteTaskById(Long id);
}
