package com.example.BibliotecaRouter.mapper;

import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.modelo.Recurso;

import java.util.function.Function;

public class RecursoBibliotecaMapper {

    public Function<RecursoBibliotecaDTO, Recurso> mapperToRecurso(String id){
        return updateRecurso -> {
            var recurso = new Recurso();
            recurso.getId();
            recurso.getTipoRecurso();
            recurso.getFechaPrestamo();
            recurso.getNombre();
            recurso.getIdArea();
            return recurso;

        };
    }
    public Function<Recurso , RecursoBibliotecaDTO> mapRecursoToDTO(){
        return entity -> new RecursoBibliotecaDTO(entity.getId(),entity.getTipoRecurso(),entity.getDisponible(),entity.getFechaPrestamo(),entity.getNombre(), entity.getIdArea());
    }

}
