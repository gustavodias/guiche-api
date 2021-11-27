package com.jvge.guicheapi.service;

import com.jvge.guicheapi.controller.dto.UsuarioDTO;
import com.jvge.guicheapi.controller.form.usuario.UsuarioForm;
import com.jvge.guicheapi.controller.form.usuario.UsuarioUpdateForm;
import com.jvge.guicheapi.model.Usuario;
import com.jvge.guicheapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(final UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDTO> findAll(){
        var usuario = usuarioRepository.findAll();
        return usuario.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public Optional<Usuario> findById(Long id){
        var usuario = usuarioRepository.findById(id);
        return usuario;
    }

    public UsuarioDTO save(UsuarioForm usuarioForm){
        Usuario usuario = usuarioForm.converte();
        usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario);
    }

    @Transactional
    public UsuarioDTO update(Long id, UsuarioUpdateForm usuarioUpdateForm){
        var usuario = usuarioUpdateForm.atualizar(id, usuarioRepository);
        return new UsuarioDTO(usuario);
    }

    public void delete(Usuario usuario){
        usuarioRepository.delete(usuario);
    }
}
