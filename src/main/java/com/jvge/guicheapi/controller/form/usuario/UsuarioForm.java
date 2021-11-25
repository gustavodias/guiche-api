package com.jvge.guicheapi.controller.form.usuario;

import com.jvge.guicheapi.model.Usuario;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioForm {

    @NotNull @NotEmpty
    private String nomeGuerra;
    @NotNull @NotEmpty
    private String senha;
    @NotNull @NotEmpty
    private String setor;

    public String getNomeGuerra() {
        return nomeGuerra;
    }

    public String getSenha() {
        return senha;
    }

    public String getSetor() {
        return setor;
    }

    public Usuario converte() {
        return new Usuario(nomeGuerra,senha,setor, "ATENDENTE");
    }
}
