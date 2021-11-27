package com.jvge.guicheapi.controller;

import com.jvge.guicheapi.controller.dto.UsuarioDTO;
import com.jvge.guicheapi.controller.form.usuario.UsuarioForm;
import com.jvge.guicheapi.controller.form.usuario.UsuarioUpdateForm;
import com.jvge.guicheapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAllUsuarios(){
        var listaUsuarios = usuarioService.findAll();
        if (listaUsuarios.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(listaUsuarios);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findOneUsuario(@PathVariable("id") Long id){
        var usuario = usuarioService.findById(id);
        return usuario.map(value -> ResponseEntity.ok(new UsuarioDTO(value))).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> saveUsuario(@RequestBody @Valid UsuarioForm form,
                                                                      UriComponentsBuilder uriComponentsBuilder){
       var usuarioDTO =  usuarioService.save(form);
        URI uri = uriComponentsBuilder.path("usuario/{id}").buildAndExpand(usuarioDTO.getId()).toUri();
        return  ResponseEntity.created(uri).body(usuarioDTO);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable("id") Long id,
                                                @RequestBody @Valid UsuarioUpdateForm usuarioUpdateForm){
        var optionalUsuario = usuarioService.findById(id);

        if (optionalUsuario.isPresent()){
            return ResponseEntity.ok(usuarioService.update(id, usuarioUpdateForm));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable("id") Long id){
        var optionalUsuario = usuarioService.findById(id);
        if (optionalUsuario.isPresent()){
            usuarioService.delete(optionalUsuario.get());
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
