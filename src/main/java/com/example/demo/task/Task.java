package com.example.demo.task;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity(name = "to_do")
@Table(name = "task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;


    public Task(createTaskDTO task) {
        this.titulo = task.titulo();
        this.descricao = task.descricao();
        this.status = task.status();
        this.dataCriacao = LocalDateTime.now();
        this.dataConclusao = (this.status == TaskStatus.CONCLUIDA) ? LocalDateTime.now() : null;
    }

    public Task(Task task) {
        this.id = task.id;
        this.titulo = task.titulo;
        this.descricao = task.descricao;
        this.status = task.status;
        this.dataCriacao = task.dataCriacao;
        this.dataConclusao = task.dataConclusao;
    }


}
