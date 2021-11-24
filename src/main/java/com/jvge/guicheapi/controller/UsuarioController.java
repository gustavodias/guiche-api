package com.jvge.guicheapi.controller;

import com.jvge.guicheapi.controller.dto.UsuarioDTO;
import com.jvge.guicheapi.model.Usuario;
import com.jvge.guicheapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //http://localhost:8080/usuario?nomeGuerra=dias
    /*@GetMapping
    @Cacheable(value = "listaDeUsuarios")
    public ResponseEntity<Page<UsuarioDTO>> listaPaginada(@RequestParam(required = false) String nomeGuerra,
                                                         @PageableDefault(sort = "id", page = 0, size = 10) Pageable paginacao) {
        Page<Usuario> usuarios = usuarioRepository.findAll(paginacao);
        return ResponseEntity.ok().body(UsuarioDTO.)
    }*/

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> lista(){
        List<Usuario> lista = usuarioRepository.findAll();
        List<UsuarioDTO> listaDto = lista.stream().map(UsuarioDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDto);
    }

}
