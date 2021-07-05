package com.example.BibliotecaRouter.usecase;

import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.mapper.RecursoBibliotecaMapper;
import com.example.BibliotecaRouter.repositorio.RepositorioRecursoBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCrearRecurso implements GuardarRecurso {
    private final RepositorioRecursoBiblioteca repositorioRecursoBiblioteca;
    private final RecursoBibliotecaMapper recursoBibliotecaMapper = new RecursoBibliotecaMapper();

    @Autowired
    public UseCaseCrearRecurso(RepositorioRecursoBiblioteca repositorioRecursoBiblioteca) {
        this.repositorioRecursoBiblioteca = repositorioRecursoBiblioteca;
    }

    @Override
    public Mono<RecursoBibliotecaDTO> apply(RecursoBibliotecaDTO recursoBibliotecaDTO) {
        var respuesta = repositorioRecursoBiblioteca.save(recursoBibliotecaMapper.mapperToRecurso(null).apply(recursoBibliotecaDTO)).map(recursoBibliotecaMapper.mapRecursoToDTO());
        return respuesta;
    }

}
