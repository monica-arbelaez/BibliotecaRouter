package com.example.BibliotecaRouter.UseCaseServiceRecurso;

import com.example.BibliotecaRouter.mapper.RespuestaAreaMapper;
import com.example.BibliotecaRouter.repositorio.RepositorioAreaTematica;
import com.example.BibliotecaRouter.repositorio.RepositorioRecursoBiblioteca;

public class UseCaseRecomendarPorArea {
    private final RepositorioRecursoBiblioteca repositorioRecursoBiblioteca;
    private final RepositorioAreaTematica repositorioAreaTematica;
    private final RespuestaAreaMapper respuestaAreaMapper = new RespuestaAreaMapper();

    public UseCaseRecomendarPorArea(RepositorioRecursoBiblioteca repositorioRecursoBiblioteca, RepositorioAreaTematica repositorioAreaTematica) {
        this.repositorioRecursoBiblioteca = repositorioRecursoBiblioteca;
        this.repositorioAreaTematica = repositorioAreaTematica;
    }

}
