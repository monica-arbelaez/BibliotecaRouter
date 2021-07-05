package com.example.BibliotecaRouter.usecase;

import com.example.BibliotecaRouter.dto.AreaTematicaDTO;
import com.example.BibliotecaRouter.mapper.AreaTematicaMapper;
import com.example.BibliotecaRouter.repositorio.RepositorioAreaTematica;
import com.example.BibliotecaRouter.repositorio.RepositorioRecursoBiblioteca;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class UseCaseConsultarAreaId implements Function<String, Mono<AreaTematicaDTO>> {
    private final RepositorioAreaTematica repositorioAreaTematica;
    private  final AreaTematicaMapper areaTematicaMapper;

    public UseCaseConsultarAreaId(RepositorioAreaTematica repositorioAreaTematica, AreaTematicaMapper areaTematicaMapper) {
        this.repositorioAreaTematica = repositorioAreaTematica;
        this.areaTematicaMapper = areaTematicaMapper;
    }

    @Override
    public Mono<AreaTematicaDTO> apply(String id) {
        var respuesta = repositorioAreaTematica.findById(id).map(areaTematicaMapper.mapAreaToAreaDTO());
        return respuesta;
    }
}
