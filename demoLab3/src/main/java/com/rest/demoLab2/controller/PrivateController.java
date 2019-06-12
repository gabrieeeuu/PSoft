package com.rest.demoLab2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrivateController {
    
    @GetMapping(value="/private")
    public String privateMsg(){
        return "Vaza que aqui eh privado";
    }

    @GetMapping(value="/public")
    public String publicMsg(){
        return "Fala chegado";
    }
}