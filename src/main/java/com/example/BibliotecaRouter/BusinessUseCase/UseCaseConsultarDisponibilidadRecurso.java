package com.example.BibliotecaRouter.BusinessUseCase;

import com.example.BibliotecaRouter.dto.RespuestaDTO;
import com.example.BibliotecaRouter.mapper.RecursoBibliotecaMapper;
import com.example.BibliotecaRouter.mapper.RespuestaMapper;
import com.example.BibliotecaRouter.repositorio.RepositorioRecursoBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;


@Service
@Validated
public class UseCaseConsultarDisponibilidadRecurso implements Function<String, Mono<RespuestaDTO>> {

    private final RepositorioRecursoBiblioteca repositorioRecursoBiblioteca;
    private final RecursoBibliotecaMapper recursoBibliotecaMapper= new RecursoBibliotecaMapper();
    private final RespuestaMapper respuestaMapper = new RespuestaMapper();

    @Autowired
    public UseCaseConsultarDisponibilidadRecurso(RepositorioRecursoBiblioteca repositorioRecursoBiblioteca) {
        this.repositorioRecursoBiblioteca = repositorioRecursoBiblioteca;
    }

    @Override
    public Mono<RespuestaDTO> apply(String id) {
        var respuesta = repositorioRecursoBiblioteca.findById(id)
                .map(recursoBibliotecaMapper.mapRecursoToDTO());
        return respuesta.map(respuestaMapper.mapperConsultarRecurso());

    }
}
