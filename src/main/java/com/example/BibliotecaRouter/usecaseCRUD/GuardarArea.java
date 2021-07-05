package com.example.BibliotecaRouter.usecaseCRUD;

import com.example.BibliotecaRouter.dto.AreaTematicaDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface GuardarArea {
    public Mono<AreaTematicaDTO> apply(AreaTematicaDTO areaTematicaDTO);
}
