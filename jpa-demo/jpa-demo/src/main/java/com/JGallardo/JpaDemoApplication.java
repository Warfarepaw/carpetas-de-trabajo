package com.JGallardo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.JGallardo.Target.ServiceOneInterface;
import com.JGallardo.model.Categoria;
import com.JGallardo.model.Perfiles;
import com.JGallardo.model.Usuarios;
import com.JGallardo.model.Vacante;
import com.JGallardo.repository.CateogriasRepository;
import com.JGallardo.repository.PerfilesRepository;
import com.JGallardo.repository.UsuariosRepository;
import com.JGallardo.repository.VacantesRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner{

	
	@Autowired
	private CateogriasRepository categoriasRepository;
	
	@Autowired
	private VacantesRepository vacRepo;
	
	@Autowired
	private PerfilesRepository perRepo;
	
	@Autowired
	private UsuariosRepository usuRepo;
	
	@Autowired
	private ServiceOneInterface soInt;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("ejemplos de spring data JPA");
		//guardar();
		//buscarUsuario();
		//soInt.annotation();
		
	}
	

	
	
	private void buscarEstatusEn() 
	{
		String[] estatus = new String[] {"Eliminada","Creada"};
		List<Vacante> vac = vacRepo.findByEstatusIn(estatus);
		System.out.println("Registros encontados: " + vac.size());
//		for(Vacante vatTemp:vac) 
//		{
//			System.out.println(vatTemp.getNombre() + "  " + vatTemp.getEstatus());		
//		}
		
		Iterator<Vacante> it = vac.iterator();
		while(it.hasNext()) 
		{
			Vacante va =  it.next();
			
		}
		
		
	}

	
	private void buscaVacantesEstatusActivas() 
	{
		List<Vacante> vac = vacRepo.findByDestacadoAndEstatusOrderByIdVacanteDesc(1,"Aprobada");
		System.out.println("Registros encontados: " + vac.size());
		for(Vacante vatTemp:vac) 
		{
			System.out.println(vatTemp.getNombre() + "  " + vatTemp.getEstatus());		
		}
	}
	
	private void buscarVacantesPorEstatus() 
	{
		List<Vacante> vac = vacRepo.findByEstatus("Aprobada");
		System.out.println("Registros encontados: " + vac.size());
		for(Vacante vatTemp:vac) 
		{
			System.out.println(vatTemp.getNombre() + "  " + vatTemp.getEstatus());		
		}
	}
	private void buscarVacantes() 
	{
		List<Vacante> vacantes = vacRepo.findAll();
		for(Vacante vacTemp : vacantes) 
		{
			System.out.println(vacTemp.getIdVacante() + " "  + vacTemp.getNombre() + " "+ vacTemp.getIdCategoria().getNombre());
		}
	}
	
	private void guardarVacante() 
	{
		
		String dateFormat = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Vacante vacante = new Vacante();
		Categoria categoria = new Categoria();
		
		categoria.setIdCategoria(15);
		
		vacante.setNombre("Profesor de Matematicas");
		vacante.setDescripcion("Escuela primaria solicita profesor para cursos de Matematicas");
		vacante.setDate(new Date());
		vacante.setSalario(10000.00);
		vacante.setEstatus("Aprobada");
		vacante.setDestacado(0);
		vacante.setImagen("escuela.png");
		vacante.setIdCategoria(categoria);
		
		vacante.setDescripcion("<h1> Los requisitos para profesor de Matematicas </h1>"); 
		
//		int total =  (int) vacRepo.findAll(PageRequest.of(0, 5)).getTotalElements();
//		for(int i = 0; i<total; i++) 
//		{
//			try {
//				vacRepo.saveAndFlush(vacante);
//			} catch (Exception e) {
//				
//			}
//		}

		vacRepo.saveAndFlush(vacante);
		
	}
	
	private void guardar(Categoria cat) 
	{
		if(cat == null) 
		{
			cat.setNombre("Finanzas");
			cat.setDescripcion("Trabajos relacionados con Finanzas y Contabilidad");
		}else 
		{
			categoriasRepository.save(cat);
			System.out.println(cat);
		}

	}
	
	private void conteo() 
	{
		categoriasRepository.count();
		long conteo = categoriasRepository.count();
		System.out.println(conteo);
	}
	
	private void eliminar() 
	{
		Optional<Categoria> optional = categoriasRepository.findById(1);
		if(optional.isPresent()) 
		{
			categoriasRepository.deleteById(optional.get().getIdCategoria());
			System.out.println("eliminando el registro: "+ optional.get());
		}else 
		{
			System.out.println("Categoria no encontrada");
		}
		
	}
	
	private void buscarPorId() 
	{
		Optional<Categoria> optional = categoriasRepository.findById(1);
		if(optional.isPresent()) 
		{
			System.out.println(optional.get().toString());
		}else 
		{
			System.out.println("Categoria no encontrada");
		}
	}
	
	private void modificar() 
	{
		Optional<Categoria> optional = categoriasRepository.findById(1);
		
		if(optional.isPresent()) 
		{
			Categoria tempCategoria = optional.get();
			tempCategoria.setNombre("Finanzas");
			tempCategoria.setDescripcion("Trabajos relacionados con Finanzas, Contabilidad y Software");
			guardar(tempCategoria);
		}else 
		{
			System.out.println("Categoria no encontrada");
		}

	}
	
	private void popularCat() 
	{
		Categoria categoria1 = new Categoria();
		Categoria categoria2 = new Categoria();
		Categoria categoria3 = new Categoria();
		
		List<Categoria> catList = new LinkedList<Categoria>();
		
		
		categoria1.setNombre("Finanzas");
		categoria1.setDescripcion("Trabajos relacionados con Finanzas");
		
		categoria2.setNombre("Contabilidad");
		categoria2.setDescripcion("Trabajos relacionados con Contabilidad");

		categoria3.setNombre("Software");
		categoria3.setDescripcion("Trabajos relacionados con Software");
		
		catList.add(categoria1);
		catList.add(categoria2);
		catList.add(categoria3);
		
		guardarTodas(catList);
	}

	private void deleteAll() 
	{
		categoriasRepository.deleteAll();
		System.out.println("se ah borrado toda la informacion de la base de datos, que tenga un excelente dia");
	}
	
	private void encontrarPorIds() 
	{
		List<Integer> ids  =new LinkedList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		
		Iterable<Categoria> categorias = categoriasRepository.findAllById(ids);
		
		for(Categoria tempCat: categorias) 
		{
			System.out.println(tempCat.toString());
		}
	}
	
	private void buscarTodos() 
	{
		Iterable <Categoria> categorias = categoriasRepository.findAll();
		
		for(Categoria tempCat: categorias) 
		{
			System.out.println(tempCat.toString());
		}
	}
	
	private void existeID() 
	{
		boolean existe = categoriasRepository.existsById(3);
		if(existe) 
		{
			System.out.println("el registro con el ID: " + 3 +" Existe");
		}
	}
	
	private void guardarTodas(List<Categoria> catList) 
	{
		categoriasRepository.saveAll(catList);
	}
	
	private void buscarTodosJPA() 
	{
		List <Categoria>categorias = categoriasRepository.findAll();
		for(Categoria cat: categorias) 
		{
			System.out.println(cat.getIdCategoria() + " " + cat.getNombre());
		}
	}
	
	private void deleteAllJPA() 
	{
		categoriasRepository.deleteAllInBatch();
	}
	
	private void buscarTodosOrdenados() 
	{
		List <Categoria>categorias = categoriasRepository.findAll(Sort.by("nombre").descending());
		for(Categoria cat: categorias) 
		{
			System.out.println(cat.getIdCategoria() + " " + cat.getNombre());
		}
	}
	
	private void buscarTodosPaginacion() 
	{
		
		Page <Categoria> pageCategorias =  categoriasRepository.findAll(PageRequest.of(0, 5));
		System.out.println("numero total de registros:"+ pageCategorias.getTotalElements());
		System.out.println("numero total de paginas:"+ pageCategorias.getTotalPages());
		for(Categoria cat: pageCategorias) 
		{
			System.out.println(cat.getIdCategoria() + " " + cat.getNombre());
		}
	}
	
	private void buscarTodosPaginacionOrdenada() 

	
	{
		Page <Categoria> pageCategorias =  categoriasRepository.findAll(PageRequest.of(0, 5,Sort.by("nombre").descending()));
		System.out.println("numero total de registros:"+ pageCategorias.getTotalElements());
		System.out.println("numero total de paginas:"+ pageCategorias.getTotalPages());
		for(Categoria cat: pageCategorias) 
		{
			System.out.println(cat.getIdCategoria() + " " + cat.getNombre());
		}
		
	}

	private void crearPerfilAplicacion() 
	{
		perRepo.saveAll(getPerfilesAplicacion());
		
	}
	
	private List<Perfiles> getPerfilesAplicacion()
	{
		
		List<Perfiles> listaPerfiles = new LinkedList<Perfiles>();
		Perfiles perfil1 = new Perfiles();
		perfil1.setPerfil("SUPERVISOR");
		
		Perfiles perfil2 = new Perfiles();
		perfil2.setPerfil("ADMINISTRADOR");
		
		Perfiles perfil3 = new Perfiles();
		perfil3.setPerfil("USUARIO");
		
		listaPerfiles.add(perfil1);
		listaPerfiles.add(perfil2);
		listaPerfiles.add(perfil3);
		
		return listaPerfiles;
			
	}

	private void crearUsuarioConUnPerfil() 
	{
		
		Usuarios usTemp = new Usuarios();
		usTemp.setNombre("Jesus Gallardo");
		usTemp.setEmail("jes.gallardo.d@gmail.com");
		usTemp.setFechaRegistro(new Date());
		usTemp.setUsername("warfarepaw");
		usTemp.setPassword("123412");
		usTemp.setEstatus(1);
		
		Perfiles per1 = new Perfiles();
		per1.setIdPerfil(1);
		
		Perfiles per2 = new Perfiles();
		per2.setIdPerfil(2);
	
//		usTemp.agregarCategoria(per1);
//		usTemp.agregarCategoria(per2);
		
		List<Perfiles> listaPerfiles = new LinkedList<Perfiles>();
		listaPerfiles.add(per1);
		listaPerfiles.add(per2);
		
		usTemp.setIdPerfiles(listaPerfiles);
		
		usuRepo.save(usTemp);
		
	}

	private void buscarUsuario() 
	{
		Optional<Usuarios> tempUsuario = usuRepo.findById(4);
		if(tempUsuario.isPresent()) 
		{
			Usuarios usuario = tempUsuario.get();
			System.out.println("Usuario: " + usuario.getNombre());
			System.out.println("Perfiles asignados");
			
			for(Perfiles per: usuario.getIdPerfiles()) 
			{
				System.out.println(per.getPerfil());
			}
		}else 
		{
			System.out.println("Usuario no encontrado");
			
		}
	}
}
