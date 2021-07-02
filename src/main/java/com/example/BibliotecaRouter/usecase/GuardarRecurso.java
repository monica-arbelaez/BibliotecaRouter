package com.example.BibliotecaRouter.usecase;

import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import reactor.core.publisher.Mono;

public interface GuardarRecurso {
    public Mono<RecursoBibliotecaDTO> apply(RecursoBibliotecaDTO recursoBibliotecaDTO);
}
