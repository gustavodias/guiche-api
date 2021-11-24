package com.jvge.guicheapi.config.db;

import com.jvge.guicheapi.model.Guiche;
import com.jvge.guicheapi.model.Usuario;
import com.jvge.guicheapi.repository.GuicheRepository;
import com.jvge.guicheapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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
        Usuario user2 = new Usuario("Vitor", "123", "teste", "user");
        Usuario user3 = new Usuario("Mateus", "123", "teste", "user");
        Usuario user4 = new Usuario("Jose", "123", "teste", "user");


        Guiche guiche1 = new Guiche(01,user1);
        Guiche guiche2 = new Guiche(02,user2);
        Guiche guiche3 = new Guiche(03,user3);
        Guiche guiche4 = new Guiche(04,user4);


        this.usuarioRepository.saveAll(Arrays.asList(user1, user2, user3, user4));
        this.guicheRepository.saveAll(Arrays.asList(guiche1, guiche2, guiche3, guiche4));
    }
}
