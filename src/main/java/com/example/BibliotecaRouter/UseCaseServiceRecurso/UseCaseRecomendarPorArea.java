package com.example.BibliotecaRouter.UseCaseServiceRecurso;

import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.dto.RespuestaAreaDTO;
import com.example.BibliotecaRouter.mapper.RecursoBibliotecaMapper;
import com.example.BibliotecaRouter.mapper.RespuestaAreaMapper;
import com.example.BibliotecaRouter.modelo.Area;
import com.example.BibliotecaRouter.modelo.Recurso;
import com.example.BibliotecaRouter.repositorio.RepositorioAreaTematica;
import com.example.BibliotecaRouter.repositorio.RepositorioRecursoBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Function;


@Service
@Validated
public class UseCaseRecomendarPorArea implements Function <String, Flux<RecursoBibliotecaDTO>> {

    private final RepositorioRecursoBiblioteca repositorioRecursoBiblioteca;
    private final RepositorioAreaTematica repositorioAreaTematica;
    private final RecursoBibliotecaMapper recursoBibliotecaMapper = new RecursoBibliotecaMapper();
    private final RespuestaAreaMapper respuestaAreaMapper = new RespuestaAreaMapper();

    @Autowired
    public UseCaseRecomendarPorArea(RepositorioRecursoBiblioteca repositorioRecursoBiblioteca, RepositorioAreaTematica repositorioAreaTematica) {
        this.repositorioRecursoBiblioteca = repositorioRecursoBiblioteca;
        this.repositorioAreaTematica = repositorioAreaTematica;
    }


    @Override
    public Flux<RecursoBibliotecaDTO> apply(String IdArea) {
        return repositorioRecursoBiblioteca.findRecursoByIdArea(IdArea)
                .map(recursoBibliotecaMapper.mapRecursoToDTO());

    }

}
