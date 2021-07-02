package com.example.BibliotecaRouter.repositorio;

import com.example.BibliotecaRouter.modelo.Area;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositorioAreaTematica extends ReactiveMongoRepository<Area, String> {
}
