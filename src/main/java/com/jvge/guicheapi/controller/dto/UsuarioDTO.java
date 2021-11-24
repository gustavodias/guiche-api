package com.jvge.guicheapi.controller.dto;

import com.jvge.guicheapi.model.Usuario;
import org.springframework.data.domain.Page;

public class UsuarioDTO {

    private Long id;
    private String nomeGuerra;
    private String setor;
    private String tipo;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nomeGuerra = usuario.getNomeGuerra();
        this.setor = usuario.getSetor();
        this.tipo = usuario.getTipo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeGuerra() {
        return nomeGuerra;
    }

    public void setNomeGuerra(String nomeGuerra) {
        this.nomeGuerra = nomeGuerra;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
