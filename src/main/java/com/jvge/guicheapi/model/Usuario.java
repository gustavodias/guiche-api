package com.jvge.guicheapi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nomeGuerra;
    private String senha;
    private String setor;
    private String tipo;

    public Usuario() {
    }

    public Usuario(Long id, String nomeGuerra, String senha, String setor, String tipo) {
        this.id = id;
        this.nomeGuerra = nomeGuerra;
        this.senha = senha;
        this.setor = setor;
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nomeGuerra, usuario.nomeGuerra) && Objects.equals(senha, usuario.senha) && Objects.equals(setor, usuario.setor) && Objects.equals(tipo, usuario.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeGuerra, senha, setor, tipo);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nomeGuerra='" + nomeGuerra + '\'' +
                ", senha='" + senha + '\'' +
                ", setor='" + setor + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public String getNomeGuerra() {
        return nomeGuerra;
    }

    public void setNomeGuerra(String nomeGuerra) {
        this.nomeGuerra = nomeGuerra;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
