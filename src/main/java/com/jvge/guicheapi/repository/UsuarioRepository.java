package com.jvge.guicheapi.repository;

import com.jvge.guicheapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByNomeGuerra(String nomeGuerra);
}
