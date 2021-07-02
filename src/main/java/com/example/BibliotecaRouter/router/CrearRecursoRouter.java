package com.example.BibliotecaRouter.router;

import com.example.BibliotecaRouter.dto.AreaTematicaDTO;
import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.usecase.UseCaseCrearArea;
import com.example.BibliotecaRouter.usecase.UseCaseRecurso;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

public class CrearRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> crearRecurso(UseCaseRecurso useCaseRecurso) {
        return route(POST("/crearRecurso").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(RecursoBibliotecaDTO.class)
                        .flatMap(questionDTO -> useCaseRecurso.apply(questionDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )

        );
    }
}
