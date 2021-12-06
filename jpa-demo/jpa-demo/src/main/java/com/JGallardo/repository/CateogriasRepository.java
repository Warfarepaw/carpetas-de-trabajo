package com.JGallardo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.JGallardo.model.Categoria;

//public interface CateogriasRepository extends CrudRepository<Categoria, Integer> {
public interface CateogriasRepository extends JpaRepository<Categoria, Integer> {

}
