package com.JGallardo.empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JGallardo.empleos.model.Categoria;

public interface CateogriasRepository extends JpaRepository<Categoria, Integer> {

}
