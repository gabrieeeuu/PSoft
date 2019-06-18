package com.rest.demoLab2.dao;

import com.rest.demoLab2.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO<T> extends JpaRepository<Usuario, String> {

    @Query(value = "Select u from Usuario u where u.login=:plogin")
    Usuario findByLogin(@Param("plogin") String login);

    Usuario save(Usuario usuario);

}