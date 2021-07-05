package com.example.BibliotecaRouter.usecaseCRUD;

import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import reactor.core.publisher.Mono;

public interface GuardarRecurso {
    public Mono<RecursoBibliotecaDTO> apply(RecursoBibliotecaDTO recursoBibliotecaDTO);
}
