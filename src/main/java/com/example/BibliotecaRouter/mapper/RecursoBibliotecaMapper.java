package com.example.BibliotecaRouter.mapper;

import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.modelo.Recurso;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RecursoBibliotecaMapper {

    public Function<RecursoBibliotecaDTO, Recurso> mapperToRecurso(String id){
        return updateRecurso -> {
            var recurso = new Recurso();
            recurso.setId(id);
            recurso.setTipoRecurso(updateRecurso.getTipoRecursoBiblioteca());
            recurso.setDisponible(updateRecurso.getRecursoDisponible());
            recurso.setFechaPrestamo(updateRecurso.getFechaPrestamoRecurso());
            recurso.setNombre( updateRecurso.getNombreRecurso());
            recurso.setIdArea(updateRecurso.getIdAreaTematica());
            return recurso;

        };
    }
    public Function<Recurso , RecursoBibliotecaDTO> mapRecursoToDTO(){
        return entity -> new RecursoBibliotecaDTO(entity.getId()
                ,entity.getTipoRecurso()
                ,entity.getDisponible()
                ,entity.getFechaPrestamo()
                ,entity.getNombre()
                ,entity.getIdArea());
    }

}
