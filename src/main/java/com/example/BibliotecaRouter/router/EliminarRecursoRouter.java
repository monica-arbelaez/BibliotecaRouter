package com.example.BibliotecaRouter.router;

import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.usecase.UseCaseEliminarRecurso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EliminarRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> eliminarRecurso(UseCaseEliminarRecurso useCaseEliminarRecurso){
        return route(DELETE("Eliminar/recurso/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request-> ServerResponse.ok()
        .body(useCaseEliminarRecurso.eliminarRecurso(request.pathVariable("id")), RecursoBibliotecaDTO.class));
    }

}
