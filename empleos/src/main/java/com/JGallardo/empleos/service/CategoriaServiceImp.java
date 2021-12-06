package com.JGallardo.empleos.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.JGallardo.empleos.model.Categoria;

@Service
public class CategoriaServiceImp implements ICategoriaService{


	
	List<Categoria> categoriaList = new LinkedList<Categoria>();
	
	public CategoriaServiceImp() {
		
		Categoria categoria1 = new Categoria();
		Categoria categoria2 = new Categoria();
		Categoria categoria3 = new Categoria();
		
		categoria1.setIdCategoria(01);
		categoria1.setNombre("AAAA");
		categoria1.setDescripcion("BBBBB");
		
		categoria2.setIdCategoria(02);
		categoria2.setNombre("AAAA");
		categoria2.setDescripcion("BBBBB");

		categoria3.setIdCategoria(03);
		categoria3.setNombre("AAAA");
		categoria3.setDescripcion("BBBBB");
		
		categoriaList.add(categoria1);
		categoriaList.add(categoria2);
		categoriaList.add(categoria3);
	}

	@Override
	public void Guardar(Categoria categoria) {
		
		categoriaList.add(categoria);
		System.out.println("ID:" + categoria.getIdCategoria() + "Nombre: "+ categoria.getNombre() + "Descripcion" + categoria.getDescripcion());
	}

	@Override
	public List<Categoria> buscarTodas() {
		
		return categoriaList;
	}

	@Override
	public Categoria buscarPorId(Integer categoriaID) {
		for(Categoria i: categoriaList) 
		{
			if(i.getIdCategoria() == categoriaID) 
			{
				return i;
			}
		}
		return null;
	}
		


}
