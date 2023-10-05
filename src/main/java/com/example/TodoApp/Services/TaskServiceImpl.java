package com.example.TodoApp.Services;

import com.example.TodoApp.Models.Task;
import com.example.TodoApp.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    public Task createNewTask(Task task){
        return taskRepository.save(task);
    }
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public Optional<Task> findTaskById(Long id){
        return taskRepository.findById(id);
    }

    public List <Task> findAllCompletedTask(){
        return taskRepository.findByCompletedTrue();
    }

    public List <Task> findAllIncompleteTask(){
        return taskRepository.findByCompletedFalse();
    }

    public void deleteTaskById(Long id){
        taskRepository.deleteById(id);
    }

    public Task updateTask(Task task){
        return taskRepository.save(task);
    }
}
