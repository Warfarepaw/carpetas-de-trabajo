package com.JGallardo.empleos.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {
	
	public static String guardarArchivo(MultipartFile multiFile, String ruta) 
	{
		
		final int NUMERO_CARACTERES_ALEATORIOS = 8;
		
		String nombreOriginal = multiFile.getOriginalFilename();
		nombreOriginal.replace(" ", "-");
		nombreOriginal = generaAleatoriosUnicos(NUMERO_CARACTERES_ALEATORIOS)+"-"+nombreOriginal;
		try {
		File imageFile = new File(ruta + nombreOriginal);
		System.out.println("Archivo: " + imageFile.getAbsolutePath());
		
		
		multiFile.transferTo(imageFile);
		return nombreOriginal;
		
		} catch (IllegalStateException | IOException e) {
			
			System.out.println("hubo un problema al procesar el guardado de archivo, para mas detalles vea el log: " + e.getMessage());
			return "" ;
			
			
		}
	}
	
	public static String generaAleatoriosUnicos(int count) 
	{
		String CARACTERES = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ1234567890";
		StringBuilder caracteresUnicos = new StringBuilder();
		
		while(count-- != 0)
		{
			int character  = (int) (Math.random() * CARACTERES.length());
			caracteresUnicos.append(CARACTERES.charAt(character));
		}
		return caracteresUnicos.toString();
	}

}
