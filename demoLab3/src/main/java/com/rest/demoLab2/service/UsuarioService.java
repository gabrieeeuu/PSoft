package com.rest.demoLab2.service;

import java.util.List;

import com.exception.usuario.UsuarioNotFoundException;
import com.rest.demoLab2.dao.UsuarioDAO;
import com.rest.demoLab2.model.Usuario;

import org.springframework.stereotype.Service;



@Service
public class UsuarioService {

   private final UsuarioDAO usuarioDAO;

   UsuarioService(UsuarioDAO usuarioDAO) {
       this.usuarioDAO = usuarioDAO;
   }

   public Usuario create(Usuario usuario) {
       return usuarioDAO.save(usuario);
   }

   public Usuario findByLogin(String login) {
       return usuarioDAO.findByLogin(login);
   }

}