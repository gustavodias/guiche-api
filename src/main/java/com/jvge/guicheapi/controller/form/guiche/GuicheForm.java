package com.jvge.guicheapi.controller.form.guiche;

import com.jvge.guicheapi.model.Guiche;
import com.jvge.guicheapi.model.Usuario;
import com.jvge.guicheapi.repository.UsuarioRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class GuicheForm {

    @NotNull
    private Integer numero;
    @NotNull @NotEmpty
    private String nomeGuerra;

    public Integer getNumero() {
        return numero;
    }

    public String getNomeGuerra() {
        return nomeGuerra;
    }

    public Guiche converter(UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.findByNomeGuerra(nomeGuerra);

        return new Guiche(numero, usuario);
    }
}
