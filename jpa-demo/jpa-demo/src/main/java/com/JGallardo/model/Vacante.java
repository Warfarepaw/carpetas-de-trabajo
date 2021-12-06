package com.JGallardo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Vacantes")
public class Vacante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVacante;
	private String nombre;
	private String descripcion;
	private Date date;
	private Double salario;
	private Integer destacado;
	private String imagen = "no-image.png";
	private String detalles;
	private String estatus;
	//@Transient
	@OneToOne
	@JoinColumn(name="idCategoria")
	private Categoria idCategoria;
	
	public Integer getIdVacante() {
		return idVacante;
	}
	public void setIdVacante(Integer idVacante) {
		this.idVacante = idVacante;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Integer getDestacado() {
		return destacado;
	}
	public void setDestacado(Integer destacado) {
		this.destacado = destacado;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Categoria getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Categoria idCategoria) {
		this.idCategoria = idCategoria;
	}
	@Override
	public String toString() {
		return "Vacante [idVacante=" + idVacante + ", nombre=" + nombre + ", descripcion=" + descripcion + ", date="
				+ date + ", salario=" + salario + ", destacado=" + destacado + ", imagen=" + imagen + ", detalles="
				+ detalles + ", estatus=" + estatus + ", idCategoria=" + idCategoria + "]";
	}
	
	

}
