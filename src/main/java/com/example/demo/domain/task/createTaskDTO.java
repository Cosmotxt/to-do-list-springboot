package com.example.demo.domain.task;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record createTaskDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        TaskStatus status,
        LocalDateTime dataCriacao,
        LocalDateTime dataConclusao
) {

}
