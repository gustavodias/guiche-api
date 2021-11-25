package com.jvge.guicheapi.controller;

import com.jvge.guicheapi.controller.dto.UsuarioDTO;
import com.jvge.guicheapi.controller.form.usuario.UsuarioForm;
import com.jvge.guicheapi.model.Usuario;
import com.jvge.guicheapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
        var lista = usuarioRepository.findAll();
        var listaDto = lista.stream().map(UsuarioDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findByID(@PathVariable("id") long id){
        var obj = usuarioRepository.findById(id);
        return obj.map(value -> ResponseEntity.ok(new UsuarioDTO(value))).orElseGet(() ->
                                ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder){
        Usuario usuario = form.converte();
        usuarioRepository.save(usuario);

        URI uri = uriBuilder.path("usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));
    }
}
