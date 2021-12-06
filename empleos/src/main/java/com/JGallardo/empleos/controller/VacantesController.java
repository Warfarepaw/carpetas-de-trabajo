package com.JGallardo.empleos.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JGallardo.empleos.model.Vacante;
import com.JGallardo.empleos.service.ICategoriaService;
import com.JGallardo.empleos.service.IVacantesService;
import com.JGallardo.empleos.util.Utileria;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	
	@Autowired
	private IVacantesService iVacantesService;
	
	@Autowired
	private ICategoriaService iCategoriasService;
	
	@Value("${empleosapp.ruta.imagenes}")
	private String rutaFinal;
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model model) 
	{
		model.addAttribute("id", idVacante);
		System.out.println("Borrando vacante con id="+idVacante);
		return "mensaje";
	}
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model ) 
	{
		Vacante vacante = new Vacante();
		vacante = iVacantesService.buscarPorid(idVacante);
		model.addAttribute("vacante", vacante);
		System.out.println("IDVacante" + vacante.toString());
		return "vacantes/detalle";
	}
	
	@GetMapping("/create")
	public String crear(Vacante vacante, Model model) 
	{
		model.addAttribute("categorias", iCategoriasService.buscarTodas());
		return "vacantes/formVacante";
	}
	
//	@PostMapping("/save")
//	public String guardar(@RequestParam ("nombre") String nombre, @RequestParam("descripcion") String descripcion, @RequestParam("estatus") String estatus, 
//			@RequestParam("fecha") String fecha, @RequestParam("destacado") int destacado, @RequestParam("salario") double salario, @RequestParam("detalles") String detalle)
//	{
//		System.out.println("Nombre: "+ nombre);
//		System.out.println("Descripcion: "+ descripcion);
//		System.out.println("Estatus: "+ estatus);
//		System.out.println("Fecha: "+ fecha);
//		System.out.println("Destacado: "+ destacado);
//		System.out.println("Salario"+ salario);
//		System.out.println("Detalles: "+ detalle);
//		
//		return "/vacantes/listVacantes";	
//	}
//	
	
	@PostMapping("/save")
	public String guardar(Vacante vacante, @RequestParam("archivoImagen") MultipartFile multiFile , BindingResult result, RedirectAttributes attributes)
	{
		if(result.hasErrors()) 
		{
			for(ObjectError error:result.getAllErrors()) 
			{
				System.out.println("ocurrio un error en: "+ error);
			}
			return "vacantes/formVacante"; 
		}
		
		
		if(!multiFile.isEmpty()) 
		{
			String nombreImagen = Utileria.guardarArchivo(multiFile, rutaFinal);
			
			if(!nombreImagen.equals(null)) {
				vacante.setImagen(nombreImagen);
			}
			
		}
		
		
		attributes.addFlashAttribute("msg", "Registro Completado");
		System.out.println("vacante: "+vacante.toString());
		iVacantesService.guardar(vacante);
		return "redirect:/vacantes/index";	
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	
	
	@GetMapping("/index")
	public String mostrarIndex(Model model, HttpServletRequest request) 
	{
		Logger.getLogger(request.getLocalAddr().toString()+" "+request.getRemoteAddr().toString()+" "+ request.getRemoteHost().toString());
		List<Vacante> lista = new LinkedList<Vacante>();
		lista = iVacantesService.buscarTodas();
		
		model.addAttribute("listaVacantes", lista);
		return "vacantes/listVacantes";
	}
	
	public String mostrarPagina(Model model) 
	{
		return "";
	}
	
}
