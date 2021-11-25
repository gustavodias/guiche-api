package com.jvge.guicheapi.controller;

import com.jvge.guicheapi.controller.dto.GuicheDTO;
import com.jvge.guicheapi.model.Guiche;
import com.jvge.guicheapi.repository.GuicheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/guiche")
public class GuicheController {

    @Autowired
    private GuicheRepository guicheRepository;

    @GetMapping
    public ResponseEntity<List<GuicheDTO>> listarGuiche(){
        var guiches = guicheRepository.findAll();
        var guicheDTOS = guiches.stream().map(GuicheDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(guicheDTOS);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GuicheDTO> getGuicheById(@PathVariable("id") long id){

        var guiche = guicheRepository.findById(id);

        return guiche.map(value -> ResponseEntity.ok(new GuicheDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
