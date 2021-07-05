package com.example.BibliotecaRouter.UseCaseServiceRecurso;

import com.example.BibliotecaRouter.dto.RespuestaDTO;
import com.example.BibliotecaRouter.mapper.RecursoBibliotecaMapper;
import com.example.BibliotecaRouter.mapper.RespuestaRecursoMapper;
import com.example.BibliotecaRouter.repositorio.RepositorioRecursoBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;


@Service
@Validated
public class UseCaseConsultarIsDisponible implements Function<String, Mono<RespuestaDTO>> {

    private final RepositorioRecursoBiblioteca repositorioRecursoBiblioteca;
    private final RecursoBibliotecaMapper recursoBibliotecaMapper= new RecursoBibliotecaMapper();
    private final RespuestaRecursoMapper respuestaRecursoMapper = new RespuestaRecursoMapper();

    @Autowired
    public UseCaseConsultarIsDisponible(RepositorioRecursoBiblioteca repositorioRecursoBiblioteca) {
        this.repositorioRecursoBiblioteca = repositorioRecursoBiblioteca;
    }

    @Override
    public Mono<RespuestaDTO> apply(String id) {
        var respuesta = repositorioRecursoBiblioteca.findById(id)
                .map(recursoBibliotecaMapper.mapRecursoToDTO());
        return respuesta.map(respuestaRecursoMapper.mapperConsultarRecurso());

    }
}
