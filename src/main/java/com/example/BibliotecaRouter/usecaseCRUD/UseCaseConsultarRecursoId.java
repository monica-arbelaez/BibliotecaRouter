package com.example.BibliotecaRouter.usecaseCRUD;


import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.mapper.RecursoBibliotecaMapper;
import com.example.BibliotecaRouter.repositorio.RepositorioRecursoBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UseCaseConsultarRecursoId {

    private final RepositorioRecursoBiblioteca repositorioRecursoBiblioteca;
    private  final RecursoBibliotecaMapper recursoBibliotecaMapper = new RecursoBibliotecaMapper() ;

    @Autowired
    public UseCaseConsultarRecursoId(RepositorioRecursoBiblioteca repositorioRecursoBiblioteca) {
        this.repositorioRecursoBiblioteca = repositorioRecursoBiblioteca;

    }
    public Mono<RecursoBibliotecaDTO> apply(String id){
        var respuesta = repositorioRecursoBiblioteca.findById(id).map(recursoBibliotecaMapper.mapRecursoToDTO());
        return respuesta;
    }

}
