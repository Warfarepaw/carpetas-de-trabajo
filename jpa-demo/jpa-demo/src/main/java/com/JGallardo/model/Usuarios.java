package com.JGallardo.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Usuarios")
public class Usuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	private String nombre;
	private String email;
	private String username;
	private String password;
	private Integer estatus;
	private Date fechaRegistro;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="UsuarioPerfil", joinColumns = @JoinColumn(name="idUsuario"), inverseJoinColumns = @JoinColumn(name="idPerfil"))
	private List<Perfiles> idPerfiles;
	
	
	public void agregarCategoria(Perfiles tempPerfiles) 
	{
		
		if(idPerfiles == null) 
		{
			idPerfiles = new LinkedList<Perfiles>();
		}
		idPerfiles.add(tempPerfiles);
	}
	
	public List<Perfiles> getIdPerfiles() {
		return idPerfiles;
	}
	public void setIdPerfiles(List<Perfiles> idPerfiles) {
		this.idPerfiles = idPerfiles;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuarios) {
		this.idUsuario = idUsuarios;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Override
	public String toString() {
		return "Usuarios [idUsuario=" + idUsuario + ", nombre=" + nombre + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", estatus=" + estatus + ", fechaRegistro=" + fechaRegistro
				+ ", idPerfiles=" + idPerfiles + "]";
	}

	
	
}
