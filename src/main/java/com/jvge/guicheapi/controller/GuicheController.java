package com.jvge.guicheapi.controller;

import com.jvge.guicheapi.controller.dto.GuicheDTO;
import com.jvge.guicheapi.controller.form.guiche.GuicheForm;
import com.jvge.guicheapi.controller.form.guiche.GuicheUpdateForm;
import com.jvge.guicheapi.model.Guiche;
import com.jvge.guicheapi.service.GuicheService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/guiche")
public class GuicheController {

    private final GuicheService guicheService;

    public GuicheController(final GuicheService guicheService) {
        this.guicheService = guicheService;
    }

    @GetMapping
    public ResponseEntity<List<GuicheDTO>> findAllGuiches(){
        var guicheDTOS = guicheService.findAll();

        if (guicheDTOS.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(guicheDTOS);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GuicheDTO> findOneGuiche(@PathVariable ("id") long id){
        Optional<Guiche> guiche = guicheService.findById(id);

        return guiche.map(value -> ResponseEntity.ok(new GuicheDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GuicheDTO> saveGuiche(@RequestBody @Valid GuicheForm guicheForm, UriComponentsBuilder uriComponentsBuilder){
        GuicheDTO guicheDTO = guicheService.save(guicheForm);

        URI uri = uriComponentsBuilder.path("guiche/{id}").buildAndExpand(guicheDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(guicheDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuicheDTO> updateGuiche(@PathVariable("id") Long id, @RequestBody @Valid GuicheUpdateForm guicheUpdateForm){

        var guicheOptional = guicheService.findById(id);

        if (!guicheOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(guicheService.update(id, guicheUpdateForm));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuiche(@PathVariable("id") long id){
        Optional<Guiche> guicheOptional = guicheService.findById(id);

        if (!guicheOptional.isPresent()){
            return ResponseEntity.notFound().build();
        } else {
            guicheService.delete(guicheOptional.get());
            return ResponseEntity.ok().build();
        }
    }

}
