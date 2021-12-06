package com.jgtienda;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jgtienda.tienda.model.Usuario;
import com.jgtienda.tienda.repository.UsuarioRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SecurityUserTest {
	
	@Autowired
	private UsuarioRepository usre;
	
	@Test
	public void contextLoads() 
	{
		Usuario us = new Usuario();
		Optional <Usuario> usuario = usre.findById(1);
		
		System.out.println(usuario.get().getNombre());
		assertTrue(usuario.isPresent());
	}

}
