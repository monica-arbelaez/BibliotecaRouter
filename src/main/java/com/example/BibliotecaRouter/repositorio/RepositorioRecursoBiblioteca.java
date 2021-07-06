package com.example.BibliotecaRouter.repositorio;

import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.modelo.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RepositorioRecursoBiblioteca extends ReactiveMongoRepository<Recurso, String> {

    Flux<Recurso> findRecursoByIdArea(String id);
    Flux<Recurso> findRecursoBytipoRecurso(String tipo);
    Mono<Recurso> findRecusoBynombre(String nombre);
}
