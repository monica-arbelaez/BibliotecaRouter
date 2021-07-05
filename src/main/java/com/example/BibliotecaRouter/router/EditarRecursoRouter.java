package com.example.BibliotecaRouter.router;


import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.usecase.UseCaseEditarRecurso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
@Configuration
public class EditarRecursoRouter {
    @Bean
    public RouterFunction<ServerResponse> editarRecurso(UseCaseEditarRecurso useCaseEditarRecurso){
        return route(PUT("/editar/recurso").and(accept(MediaType.APPLICATION_JSON)),
                request-> request.bodyToMono(RecursoBibliotecaDTO.class)
                    .flatMap(recursoBibliotecaDTO -> useCaseEditarRecurso.apply(recursoBibliotecaDTO)
                    .flatMap(result-> ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(result))
                    ));
    }
}
