package com.example.BibliotecaRouter.dto;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class RespuestaDTO {
    @NotBlank
    private String respuesta;
    @NotBlank
    private Boolean disponible;
    @NotBlank
    private String fechaPrestamo;

    public RespuestaDTO() {
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RespuestaDTO that = (RespuestaDTO) o;
        return Objects.equals(respuesta, that.respuesta) && Objects.equals(disponible, that.disponible) && Objects.equals(fechaPrestamo, that.fechaPrestamo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(respuesta, disponible, fechaPrestamo);
    }

    @Override
    public String toString() {
        return "RespuestaDTO{" +
                "respuesta='" + respuesta + '\'' +
                ", disponible=" + disponible +
                ", fechaPrestamo='" + fechaPrestamo + '\'' +
                '}';
    }
}