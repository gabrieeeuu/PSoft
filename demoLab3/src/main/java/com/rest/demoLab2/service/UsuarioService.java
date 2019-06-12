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

   public Usuario update(Usuario usuarioToUpdate) throws UsuarioNotFoundException {


       Usuario Usuario = usuarioDAO.findByLogin(usuarioToUpdate.getLogin());
       if (Usuario == null)
           throw new  UsuarioNotFoundException("Could not update. The Usuario does not exist.");

       return usuarioDAO.save(usuarioToUpdate);
   }

   public Usuario findByLogin(String login) {
       return usuarioDAO.findByLogin(login);
   }

   public List<Usuario> findAll(){
       return usuarioDAO.findAll();
   }

}