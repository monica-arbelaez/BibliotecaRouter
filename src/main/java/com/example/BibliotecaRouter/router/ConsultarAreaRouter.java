package com.example.BibliotecaRouter.router;

import com.example.BibliotecaRouter.dto.AreaTematicaDTO;
import com.example.BibliotecaRouter.usecase.UseCaseListarArea;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class ConsultarAreaRouter {

    @Bean
    public RouterFunction<ServerResponse> listarAreaTematica(UseCaseListarArea useCaseListarArea){
        return route(GET("/area/consultar").and(accept(MediaType.APPLICATION_JSON)),
                request->ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCaseListarArea.get(), AreaTematicaDTO.class))
        );
    }


}
