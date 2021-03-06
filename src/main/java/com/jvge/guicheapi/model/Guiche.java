package com.jvge.guicheapi.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Guiche {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    private Integer numero;
    private LocalDateTime data = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    public Guiche() {
    }

    public Guiche(Integer numero, Usuario usuario) {
        this.numero = numero;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Guiche{" +
                "id=" + id +
                ", numero=" + numero +
                ", data=" + data +
                ", usuario=" + usuario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guiche guiche = (Guiche) o;
        return id == guiche.id && Objects.equals(numero, guiche.numero) && Objects.equals(data, guiche.data) && Objects.equals(usuario, guiche.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, data, usuario);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
