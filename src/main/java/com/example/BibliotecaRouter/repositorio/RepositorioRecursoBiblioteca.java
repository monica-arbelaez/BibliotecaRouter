package com.example.BibliotecaRouter.repositorio;

import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.modelo.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface RepositorioRecursoBiblioteca extends ReactiveMongoRepository<Recurso, String> {

    Flux<Recurso> findRecursoByIdArea(String id);
}
