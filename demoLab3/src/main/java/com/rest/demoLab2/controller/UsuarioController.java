package com.rest.demoLab2.controller;

import com.exception.usuario.UsuarioNotFoundException;
import com.rest.demoLab2.model.Usuario;
import com.rest.demoLab2.service.UsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/v1/usuarios"})
public class UsuarioController {
    private UsuarioService usuarioService;

   UsuarioController(UsuarioService usuarioService) {
       this.usuarioService = usuarioService;
   }

   @PostMapping(value = "/")
   @ResponseBody
   public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
       Usuario newUsuario = usuarioService.create(usuario);

       if (newUsuario == null) {
           throw  new InternalError("Something went wrong");
       }

       return new ResponseEntity<Usuario>(newUsuario, HttpStatus.CREATED);
   }

}