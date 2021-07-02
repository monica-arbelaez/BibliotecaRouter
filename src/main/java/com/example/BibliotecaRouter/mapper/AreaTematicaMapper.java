package com.example.BibliotecaRouter.mapper;

import com.example.BibliotecaRouter.dto.AreaTematicaDTO;
import com.example.BibliotecaRouter.modelo.Area;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AreaTematicaMapper {


    public Function<AreaTematicaDTO, Area> mapperToArea(String id){
        return  updateArea ->{
            var area = new Area();
            area.setIdArea(id);
            area.setCategoriaArea(updateArea.getCategoriaAreaTematica());
            return area;
        };
    }

    public Function<Area, AreaTematicaDTO> mapAreaToAreaDTO(){
        return entity -> new AreaTematicaDTO(entity.getIdArea(), entity.getCategoriaArea());
    }


}
