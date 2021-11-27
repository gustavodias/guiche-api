package com.jvge.guicheapi.service;

import com.jvge.guicheapi.controller.dto.GuicheDTO;
import com.jvge.guicheapi.controller.form.guiche.GuicheForm;
import com.jvge.guicheapi.model.Guiche;
import com.jvge.guicheapi.repository.GuicheRepository;
import com.jvge.guicheapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GuicheService {

    // Constructor Injection
    private final GuicheRepository guicheRepository;
    private final UsuarioRepository usuarioRepository;

    public GuicheService(final GuicheRepository guicheRepository, final UsuarioRepository usuarioRepository) {
        this.guicheRepository = guicheRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<GuicheDTO> findAll(){
        List<Guiche> guiches = guicheRepository.findAll();

        return guiches.stream().map(GuicheDTO::new).collect(Collectors.toList());
    }

    public Optional<Guiche> findById(long id){
        Optional<Guiche> guiche = guicheRepository.findById(id);

        return guiche;
    }

    public GuicheDTO save(GuicheForm guicheForm){
        Guiche guiche = guicheForm.converter(usuarioRepository);
        guicheRepository.save(guiche);

        return new GuicheDTO(guiche);
    }
}
