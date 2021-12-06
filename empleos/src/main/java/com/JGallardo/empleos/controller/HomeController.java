package com.JGallardo.empleos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.JGallardo.empleos.model.Vacante;
import com.JGallardo.empleos.service.IVacantesService;

@Controller
public class HomeController {
	
	@Autowired
	private IVacantesService serviceVacantes;
	
	@GetMapping("/tabla")
	public String MostrarTabla(Model modelo) 
	{
		
		List<Vacante> lista = new LinkedList<Vacante>();
		//lista = getVacantes();
		lista = serviceVacantes.buscarTodas();
		modelo.addAttribute("lista", lista);
		
		return "tabla";
	}

	@GetMapping("/detalle")
	public String mostrarDetalle(Model modelo) 
	{
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de comunicaciones");
		vacante.setDescripcion("Se solicita ingeniero para dar soporte a intra net ");
		vacante.setDate(new Date());
		vacante.setSalario(9700.0);
		modelo.addAttribute("detalle", vacante);
		
		return "detalle";
	}
	
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) 
	{
		List<String> lista = new LinkedList<String>();
		
		lista.add("Ingeniero de Sistemas");
		lista.add("Auxiliar de contabilidad");
		lista.add("Vendedor");
		lista.add("Arquitecto");
		
		model.addAttribute("empleos", lista);
		
		
		return "listado";
	}
	
	
	@GetMapping("/")
	public String mostrarHome(Model modelo) 
	{
//		model.addAttribute("mensaje","Bienvenidos a JGallardo Empleos");
//		model.addAttribute("fecha", new Date());
		
		List<Vacante> lista = new LinkedList<Vacante>();
		//lista = getVacantes();
		lista = serviceVacantes.buscarTodas();
		modelo.addAttribute("lista", lista);
		
		return "home";
	}
	

	public List<Vacante> getVacantes()
	{
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		List<Vacante> lista = new LinkedList<Vacante>();
		try {
			Vacante vacante1 = new Vacante();
			Vacante vacante2 = new Vacante();
			Vacante vacante3 = new Vacante();
			Vacante vacante4 = new Vacante();
			Vacante vacante5 = new Vacante();
			
			
			vacante1.setIdVacante(01);
			vacante1.setNombre("Ingeniero Civil");
			vacante1.setDescripcion("solicitamos Ingeniero Civil para la construccion de un puente peatonal");
			vacante1.setDate(sdf.parse(sdf.format(new Date())));
			vacante1.setSalario(9700.0);
			vacante1.setDestacado(1);
			vacante1.setImagen("empresa1.png");
			
			vacante2.setIdVacante(02);
			vacante2.setNombre("Contador publico");
			vacante2.setDescripcion("Empresa Importante solicita contador con 5 años de experiencia");
			vacante2.setDate(sdf.parse(sdf.format(new Date())));
			vacante2.setSalario(8700.0);
			vacante2.setDestacado(0);
			vacante2.setImagen("empresa2.png");
			
			vacante3.setIdVacante(03);
			vacante3.setNombre("Ingeniero Electrico");
			vacante3.setDescripcion("Empresa Internacional solicita Ingeniero mecanico para mantenimiento de la instalacion electrica");
			vacante3.setDate(sdf.parse(sdf.format(new Date())));
			vacante3.setSalario(10700.0);
			vacante3.setDestacado(0);
			
			vacante4.setIdVacante(04);
			vacante4.setNombre("Diseñador grafico");
			vacante4.setDescripcion("Solicitamos diseñador grafico titulado para diseñar publicidad de la empresa");
			vacante4.setDate(sdf.parse(sdf.format(new Date())));
			vacante4.setSalario(7700.0);
			vacante4.setDestacado(1);
			
			vacante5.setIdVacante(05);
			vacante5.setNombre("Ingeniero de software");
			vacante5.setDescripcion("se solicita ingeniero de software para crear programad pedorros");
			vacante5.setDate(sdf.parse(sdf.format(new Date())));
			vacante5.setSalario(12700.0);
			vacante5.setDestacado(0);
			vacante5.setImagen("empresa3.png");
			
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			lista.add(vacante5);
			
		} catch (ParseException e) {
			System.out.println("parse error:" + e);
		}

		return lista;
	}

}
