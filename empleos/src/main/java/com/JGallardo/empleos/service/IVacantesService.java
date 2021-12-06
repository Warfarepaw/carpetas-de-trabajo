package com.JGallardo.empleos.service;

import java.util.List;

import com.JGallardo.empleos.model.Vacante;

public interface IVacantesService {
	
	Vacante buscarPorid(Integer idVacante);
	List<Vacante> buscarTodas();
	void guardar(Vacante vacante);
}
