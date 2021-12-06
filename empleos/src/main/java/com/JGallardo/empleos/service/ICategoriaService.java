package com.JGallardo.empleos.service;

import java.util.List;

import com.JGallardo.empleos.model.Categoria;

public interface ICategoriaService {
	
	void Guardar (Categoria categoria);
	List<Categoria> buscarTodas();
	Categoria buscarPorId(Integer categoriaID);

}
