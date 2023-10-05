package com.example.TodoApp.Controllers;

import com.example.TodoApp.Models.Task;
import com.example.TodoApp.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public List <Task> getAllTasks(){
        return taskService.getAllTask();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") Long id){
        return taskService.findTaskById(id).get();
    }

    @GetMapping("/completed")
    public List <Task> getAllCompletedTasks(){
        return taskService.findAllCompletedTask();
    }

    @GetMapping("/incomplete")
    public List <Task> getAllIncompleteTasks(){
        return taskService.findAllIncompleteTask();
    }

    @PostMapping("/")
    public Task createTask(@RequestBody Task task){
        return taskService.createNewTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id,
                           @RequestBody Task task){
        task.setTaskId(id);
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTask(@PathVariable("id") Long id){
        taskService.deleteTaskById(id);
        return true;
    }
}