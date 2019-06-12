package com.rest.demoLab2.controller;

import java.util.Date;

import javax.servlet.ServletException;

import com.rest.demoLab2.model.Usuario;
import com.rest.demoLab2.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/v1/auth")
public class LoginController {
    
    private final String TOKEN_KEY = "banana";
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/login")
    public LoginResponse authenticate(@RequestBody Usuario usuario) throws ServletException {

        // Recupera o usuario
        Usuario authUsuario = usuarioService.findByLogin(usuario.getLogin());
        
        // verificacoes
        if(authUsuario == null) {
            throw new ServletException("Usuario nao encontrado!");
        }
        
        if(!authUsuario.getPassword().equals(usuario.getPassword())) {
            throw new ServletException("Senha invalida!");
        }
        
        String token = Jwts.builder().
                setSubject(authUsuario.getLogin()).
                signWith(SignatureAlgorithm.HS512, TOKEN_KEY).
                setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000))
                .compact();
        
        return new LoginResponse(token);
        
        
    }
    
    private class LoginResponse {
        public String token;
        
        public LoginResponse(String token) {
            this.token = token;
        }
    }
    
}