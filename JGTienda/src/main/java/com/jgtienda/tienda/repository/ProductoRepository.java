package com.jgtienda.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jgtienda.tienda.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
