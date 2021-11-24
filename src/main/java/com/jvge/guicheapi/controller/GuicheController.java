package com.jvge.guicheapi.controller;

import com.jvge.guicheapi.repository.GuicheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/guiche")
public class GuicheController {

    @Autowired
    private GuicheRepository guicheRepository;
}
