package com.example.demo.task;

import java.time.LocalDateTime;

public record createTaskDTO(
        String titulo,
        String descricao,
        TaskStatus status,
        LocalDateTime dataCriacao,
        LocalDateTime dataConclusao
) {

}
