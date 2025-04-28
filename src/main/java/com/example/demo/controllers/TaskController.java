package com.example.demo.controllers;

import com.example.demo.domain.task.ChangedTask;
import com.example.demo.domain.task.Task;
import com.example.demo.domain.task.createTaskDTO;
import com.example.demo.services.TaskService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    @Transactional
    public ResponseEntity createTask(@RequestBody @Valid createTaskDTO task, UriComponentsBuilder uriBuilder) {
        return taskService.newTask(new Task(task), uriBuilder);
    }

    @GetMapping
    public ResponseEntity<Page> showTasks(Pageable tasksView) {
        return taskService.show(tasksView);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateTask(@RequestBody @Valid ChangedTask data) {
        return taskService.update(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTask(@PathVariable Long id) {
        return taskService.delete(id);
    }



}
