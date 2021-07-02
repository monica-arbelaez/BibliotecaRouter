package com.example.BibliotecaRouter.repositorio;

import com.example.BibliotecaRouter.modelo.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositorioRecursoBiblioteca extends ReactiveMongoRepository<Recurso, String> {
}
