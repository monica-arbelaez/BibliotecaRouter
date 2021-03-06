package com.example.BibliotecaRouter.usecaseCRUD;

import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.mapper.RecursoBibliotecaMapper;
import com.example.BibliotecaRouter.repositorio.RepositorioRecursoBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class UseCaseEditarRecurso implements Function<RecursoBibliotecaDTO, Mono<RecursoBibliotecaDTO>> {

    private final RepositorioRecursoBiblioteca repositorioRecursoBiblioteca;
    private final RecursoBibliotecaMapper  recursoBibliotecaMapper = new RecursoBibliotecaMapper();

    @Autowired
    public UseCaseEditarRecurso(RepositorioRecursoBiblioteca repositorioRecursoBiblioteca) {
        this.repositorioRecursoBiblioteca = repositorioRecursoBiblioteca;
    }


    @Override
    public Mono<RecursoBibliotecaDTO> apply(RecursoBibliotecaDTO recursoBibliotecaDTO) {
        return repositorioRecursoBiblioteca.save(recursoBibliotecaMapper.mapperToRecurso(recursoBibliotecaDTO.getIdRecurso())
                .apply(recursoBibliotecaDTO))
                .map(recursoBibliotecaMapper.mapRecursoToDTO());

    }
}
