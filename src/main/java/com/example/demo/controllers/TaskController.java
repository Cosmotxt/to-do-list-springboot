package com.example.demo.controllers;

import com.example.demo.services.TaskService;
import com.example.demo.task.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    @Transactional
    public void createTask(@RequestBody @Valid createTaskDTO task) {
        taskService.newTask(new Task(task));
    }

    @GetMapping
    public Page showTasks(Pageable tasksView) {
        return taskService.show(tasksView);

    }

    @PutMapping
    @Transactional
    public void updateTask(@RequestBody @Valid ChangedTask data) {
        taskService.update(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteTask(@PathVariable Long id) {
        taskService.delete(id);
    }



}
