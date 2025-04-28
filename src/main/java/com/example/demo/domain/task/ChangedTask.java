package com.example.demo.domain.task;

import jakarta.validation.constraints.NotNull;

public record ChangedTask(
        @NotNull
        Long id,
        TaskStatus status,
        String titulo,
        String descricao
) {
}
