package com.jgtienda.tienda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ListaArticulos")
public class ListaArticulos {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idListaArticulos;
	private String articulos;
	
	public Integer getIdListaArticulos() {
		return idListaArticulos;
	}
	public void setIdListaArticulos(Integer idListaArticulos) {
		this.idListaArticulos = idListaArticulos;
	}
	public String getArticulos() {
		return articulos;
	}
	public void setArticulos(String articulos) {
		this.articulos = articulos;
	}
	@Override
	public String toString() {
		return "ListaArticulos [idListaArticulos=" + idListaArticulos + ", articulos=" + articulos + "]";
	}
	
	
	
	
}
