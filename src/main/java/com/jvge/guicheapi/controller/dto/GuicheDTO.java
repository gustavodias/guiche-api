package com.jvge.guicheapi.controller.dto;

import com.jvge.guicheapi.model.Guiche;

import java.time.LocalDateTime;

public class GuicheDTO {

    private long id;
    private Integer numero;
    private LocalDateTime data;

    public GuicheDTO(Guiche guiche) {
        this.id = guiche.getId();
        this.numero = guiche.getNumero();
        this.data = guiche.getData();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
