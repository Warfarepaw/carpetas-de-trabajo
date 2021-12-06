package com.jgtienda.tienda.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jgtienda.tienda.model.Perfil;
import com.jgtienda.tienda.model.Usuario;
import com.jgtienda.tienda.repository.UsuarioRepository;

@Service
public class UserService implements UserDetailsService{

	
	
	@Autowired
	UsuarioRepository usrep;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario us = usrep.findByNombre(username);
		System.out.println(us.toString());
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(Perfil p : us.getIdPerfiles()) 
		{
			authorities.add(new SimpleGrantedAuthority(p.getPerfil()));
		}
		
		UserDetails usDe = new User(us.getNombre(), us.getPassword(), authorities);
		
		return usDe;
	}

}
//public class UserService
//{
//}