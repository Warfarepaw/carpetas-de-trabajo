package com.JGallardo.empleos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JGallardo.empleos.model.Categoria;
import com.JGallardo.empleos.service.ICategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private ICategoriaService categoriaService;

	@GetMapping("/index")
	public String mostrarIndex(Model model)
	{
		model.addAttribute("ListCategorias", categoriaService.buscarTodas());
		return "categorias/listCategorias";
	}
	
	@GetMapping("/create")
	public String crear(Model model)
	{
		
		return "categorias/formCategorias";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes)
	{
		if(result.hasErrors()) 
		{
			for(ObjectError error:result.getAllErrors()) 
			{
				System.out.println("ocurrio un error en: "+ error);
			}
			return "vacantes/formVacante"; 
		}
		attributes.addFlashAttribute("msg", "Registro Completado");
		categoriaService.Guardar(categoria);
		System.out.println("Categoria: "+categoria.getNombre()+"Descripcion: "+ categoria.getDescripcion());
		return "redirect:/categorias/index";
	}
	
	public String buscarPorId(Integer Id, Model model) 
	{
		Categoria categoria = categoriaService.buscarPorId(Id);
		model.addAttribute("ListCategorias", categoria);
		return "categorias/listCategorias";
	}
	
	
}
