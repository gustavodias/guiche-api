package com.jvge.guicheapi.controller;

import com.jvge.guicheapi.controller.dto.UsuarioDTO;
import com.jvge.guicheapi.model.Usuario;
import com.jvge.guicheapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> lista(){
        List<Usuario> lista = usuarioRepository.findAll();
        List<UsuarioDTO> listaDto = lista.stream().map(UsuarioDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findByID(@PathVariable("id") long id){
        var obj = usuarioRepository.findById(id);
        return obj.map(value -> ResponseEntity.ok(new UsuarioDTO(value))).orElseGet(() ->
                                ResponseEntity.notFound().build());
    }

}
