package com.jvge.guicheapi.controller.form.guiche;

import com.jvge.guicheapi.model.Guiche;
import com.jvge.guicheapi.repository.GuicheRepository;

import javax.validation.constraints.NotNull;

public class GuicheUpdateForm {

    @NotNull
    private Integer numero;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Guiche atualizarGuiche(Long id, GuicheRepository guicheRepository){
        Guiche guiche = guicheRepository.getById(id);
        guiche.setNumero(this.numero);

        return guiche;
    }
}
