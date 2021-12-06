package com.JGallardo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JGallardo.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer>{

		List<Vacante> findByEstatus(String estatus);
		
		List<Vacante> findByDestacadoAndEstatusOrderByIdVacanteDesc(int destacado, String estatus);
		
		List<Vacante> findBySalarioBetween(double s1, double s2);
		
		List<Vacante> findByEstatusIn(String[] estatus);
}