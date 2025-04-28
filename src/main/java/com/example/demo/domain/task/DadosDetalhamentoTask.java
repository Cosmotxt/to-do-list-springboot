package com.example.demo.domain.task;

public record DadosDetalhamentoTask(
        Long id,
        String titulo,
        String descricao,
        TaskStatus status
) {
    public DadosDetalhamentoTask(Task task) {
        this(task.getId(), task.getTitulo(), task.getDescricao(), task.getStatus());
    }
}
