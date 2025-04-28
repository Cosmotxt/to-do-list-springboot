package com.example.demo.services;

import com.example.demo.domain.task.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public ResponseEntity newTask(Task task, UriComponentsBuilder uriBuilder) {
        taskRepository.save(task);
        var uri = uriBuilder.path("/task/{id}").buildAndExpand(new DadosDetalhamentoTask(task)).toUri();
        return ResponseEntity.created(uri).body("Task criada: " + new DadosDetalhamentoTask(task));
    }

    public ResponseEntity<DadosDetalhamentoTask> update(ChangedTask changedTask) {
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

        taskRepository.save(task);

        return ResponseEntity.ok(new DadosDetalhamentoTask(task));
    }

    public ResponseEntity<Page> show(Pageable tasksView) {
        var page = taskRepository.findAll(tasksView).map(Task::new);
        return ResponseEntity.ok(page);
    }

    public ResponseEntity delete(Long id) {
        var taskToDelete = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada com id " + id));
        taskRepository.delete(taskToDelete);
        return  ResponseEntity.noContent().build();
    }
}
