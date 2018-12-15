package com.sopra.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sopra.springboot.app.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

	public Usuario findByUsername(String username);
}
