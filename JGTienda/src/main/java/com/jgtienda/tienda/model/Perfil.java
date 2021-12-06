package com.jgtienda.tienda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Perfiles")
public class Perfil {
	
	@Id
	private Integer idPerfil;
	private String perfil;
	
	public Integer getIfPerfil() {
		return idPerfil;
	}
	public void setIfPerfil(Integer ifPerfil) {
		this.idPerfil = ifPerfil;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	@Override
	public String toString() {
		return "Perfil [ifPerfil=" + idPerfil + ", perfil=" + perfil + "]";
	}
	
	
	

}
