package com.example.BibliotecaRouter.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Area {
    @Id
    private String idArea;
    private String categoriaArea;

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public String getCategoriaArea() {
        return categoriaArea;
    }

    public void setCategoriaArea(String categoriaArea) {
        this.categoriaArea = categoriaArea;
    }
}