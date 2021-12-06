package com.jgtienda.tienda;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.jgtienda.tienda.model.Perfil;
import com.jgtienda.tienda.model.Usuario;
import com.jgtienda.tienda.repository.UsuarioRepository;

@SpringBootApplication
@ComponentScan({"com.jgtienda.tienda.controller"})
public class AppMiTienda implements CommandLineRunner{

	@Autowired
	UsuarioRepository usre;
	
	public static void main(String[] args) {
		SpringApplication.run(AppMiTienda.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("programa corriendo");
		//createUser();
		//userById(); 
	}
	
	public void userById() 
	{
		Usuario us = new Usuario();
		Optional<Usuario> op = usre.findById(1);
		if(op.isPresent()) 
		{
			System.out.println(op.get().getNombre());
		}else 
		{
			System.out.println("error conexion");
		}
		
	}
	
	public void createUser() 
	{
		Usuario us = new Usuario();
		us.setNombre("Jesus Gallardo");
		us.setFechaRegistro(new Date());
		us.setEmail("jes.gallardo.d@gmail.com");
		us.setUsername("JGallardo");
		us.setEstatus(1);
		us.setPassword("JGallardo");
		
		Perfil p1 = new Perfil();
		p1.setIfPerfil(1);
		
		Perfil p2 = new Perfil();
		p2.setIfPerfil(2);
		
		List<Perfil> listaP = new LinkedList<Perfil>();
		listaP.add(p1);
		listaP.add(p2);
		us.setIdPerfiles(listaP);
		
		usre.save(us);
	}
	
	


}
