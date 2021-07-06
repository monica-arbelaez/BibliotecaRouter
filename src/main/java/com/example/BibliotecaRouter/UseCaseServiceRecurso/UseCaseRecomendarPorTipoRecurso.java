package com.example.BibliotecaRouter.UseCaseServiceRecurso;

import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.mapper.RecursoBibliotecaMapper;
import com.example.BibliotecaRouter.repositorio.RepositorioRecursoBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
@Validated
public class UseCaseRecomendarPorTipoRecurso implements Function<String, Flux<RecursoBibliotecaDTO>> {
    private final RecursoBibliotecaMapper recursoBibliotecaMapper = new RecursoBibliotecaMapper();
    private final RepositorioRecursoBiblioteca repositorioRecursoBiblioteca;

    @Autowired
    public UseCaseRecomendarPorTipoRecurso(RepositorioRecursoBiblioteca repositorioRecursoBiblioteca) {
        this.repositorioRecursoBiblioteca = repositorioRecursoBiblioteca;
    }

    @Override
    public Flux<RecursoBibliotecaDTO> apply(String tipoRecurso) {
        var tipo = repositorioRecursoBiblioteca.findRecursoBytipoRecurso(tipoRecurso).map(recursoBibliotecaMapper.mapRecursoToDTO());
        return tipo;
    }
}
