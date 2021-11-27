package com.jvge.guicheapi.controller.form.usuario;

import com.jvge.guicheapi.model.Usuario;
import com.jvge.guicheapi.repository.UsuarioRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioUpdateForm {


        @NotNull @NotEmpty
        private String nomeGuerra;
        @NotNull @NotEmpty
        private String senha;
        @NotNull @NotEmpty
        private String setor;
        @NotNull @NotEmpty
        private String tipo;

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

        public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
                Usuario usuario = usuarioRepository.getById(id);
                System.out.println("teste " + usuario.getNomeGuerra() + " " + this.nomeGuerra);
                usuario.setNomeGuerra(this.nomeGuerra);
                usuario.setSenha(this.senha);
                usuario.setSetor(this.setor);
                usuario.setTipo(this.tipo);
            return usuario;
        }
}
