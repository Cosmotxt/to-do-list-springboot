package com.example.demo.services;

import com.example.demo.task.*;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public void newTask(Task task) {
        taskRepository.save(task);
    }

    public Task update(ChangedTask changedTask) {
        Task task = taskRepository.findById(changedTask.id())
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        if (changedTask.titulo() != null) {
            task.setTitulo(changedTask.titulo());
        }
        if (changedTask.descricao() != null) {
            task.setDescricao(changedTask.descricao());
        }
        if (changedTask.status() != null) {
            task.setStatus(changedTask.status());
        }

        if(changedTask.status() == TaskStatus.CONCLUIDA && task.getDataConclusao() == null) {
            task.setDataConclusao(LocalDateTime.now());
        }

        return taskRepository.save(task);
    }

    public Page show(Pageable tasksView) {
        return taskRepository.findAll(tasksView).map(Task::new);
    }

    public void delete(Long id) {
        var taskToDelete = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada com id " + id));
        taskRepository.delete(taskToDelete);
    }
}
