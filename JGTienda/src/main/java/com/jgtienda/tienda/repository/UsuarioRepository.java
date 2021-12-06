package com.jgtienda.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jgtienda.tienda.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{

	Usuario findByNombre(String nombre);
}
