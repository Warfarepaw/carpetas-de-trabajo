package com.jgtienda.tienda.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ventas")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVenta;
	private Date fechaCompra;
	private Integer cantidadArticulos;
	private Double cantidadTotal;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario")
	private Usuario idUsuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idListaArticulos")
	private ListaArticulos idListaArticulos;
	
}
