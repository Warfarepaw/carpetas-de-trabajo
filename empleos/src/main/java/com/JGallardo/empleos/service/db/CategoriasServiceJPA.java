package com.JGallardo.empleos.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.JGallardo.empleos.model.Categoria;
import com.JGallardo.empleos.repository.CateogriasRepository;
import com.JGallardo.empleos.service.ICategoriaService;

@Service
@Primary
public class CategoriasServiceJPA implements ICategoriaService{

	@Autowired(required=true)
	private CateogriasRepository repo;
	
	public void Guardar (Categoria categoria) 
	{
		repo.save(categoria);
	}
	public List<Categoria> buscarTodas()
	{
		return repo.findAll();
		
	}
	public Categoria buscarPorId(Integer categoriaID) 
	{
		Optional<Categoria> op = repo.findById(categoriaID);
		if(op.isPresent()) 
		{
			return op.get();
		}
		return null;
		
	}

}
