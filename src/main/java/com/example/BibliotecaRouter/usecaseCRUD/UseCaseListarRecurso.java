package com.example.BibliotecaRouter.usecaseCRUD;

import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.mapper.RecursoBibliotecaMapper;
import com.example.BibliotecaRouter.repositorio.RepositorioRecursoBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
public class UseCaseListarRecurso implements Supplier<Flux<RecursoBibliotecaDTO>> {

    private final RepositorioRecursoBiblioteca repositorioRecursoBiblioteca;
    private final RecursoBibliotecaMapper recursoBibliotecaMapper = new RecursoBibliotecaMapper();

    @Autowired
    public UseCaseListarRecurso(RepositorioRecursoBiblioteca repositorioRecursoBiblioteca) {
        this.repositorioRecursoBiblioteca = repositorioRecursoBiblioteca;

    }


    @Override
    public Flux<RecursoBibliotecaDTO> get() {
        var respuesta = repositorioRecursoBiblioteca.findAll().map(recursoBibliotecaMapper.mapRecursoToDTO());
        return respuesta;
    }
}
