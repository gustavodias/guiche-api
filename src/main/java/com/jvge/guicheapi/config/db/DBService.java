package com.jvge.guicheapi.config.db;

import com.jvge.guicheapi.model.Guiche;
import com.jvge.guicheapi.model.Usuario;
import com.jvge.guicheapi.repository.GuicheRepository;
import com.jvge.guicheapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class DBService {
    private UsuarioRepository usuarioRepository;
    private GuicheRepository guicheRepository;

    public DBService(UsuarioRepository usuarioRepository, GuicheRepository guicheRepository) {
        this.usuarioRepository = usuarioRepository;
        this.guicheRepository = guicheRepository;
    }

    public void instaciaBaseDeDados(){
        Usuario user1 = new Usuario("dias", "123", "teste", "adm");
        Guiche guiche1 = new Guiche(01,user1);

        this.usuarioRepository.save(user1);
        this.guicheRepository.save(guiche1);
    }
}
