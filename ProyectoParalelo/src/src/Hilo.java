package src;

import java.util.Random;

public class Hilo implements Runnable {

	Thread t;
	String nombre = "cuadrado";
	int base = 0;
	int altura = 0;
	
	public Hilo(String nombre) 
	{
		this.nombre = nombre;
		t = new Thread(this,"hilo1");
		t.start(); 
	}
	
	public Hilo(int base, int altura) 
	{
		this.base = base;
		this.altura = altura;
		t = new Thread(this,"hilo2");
		t.start(); 
	}
	
	@Override
	public void run() {
		try {
			
			if(altura!=0 && base!=0) 
			{
				int area = base * altura;
				System.out.println("el area de tu cuadrado es " + area);
			}else 
			{
				Random rand = new Random(); 
				int ran = rand.nextInt(10); 
				
				switch (ran) 
				{
				case 0:
					System.out.println(nombre+" tu fortuna de hoy es ganar un premio");
					break;
				case 1:
					System.out.println(nombre+" tu fortuna de hoy es saludar un conocido");
					break;
				case 2:
					System.out.println(nombre+" tu fortuna de hoy es agendar un viaje");
					break;
				case 3:
					System.out.println(nombre+" tu fortuna de hoy es ganar dinero sorpresa");
					break;
				case 4:
					System.out.println(nombre+" tu fortuna de hoy ganar un juego");
					break;
				case 5:
					System.out.println(nombre+" tu fortuna de hoy es comer algo delicioso");
					break;
				case 6:
					System.out.println(nombre+" tu fortuna de hoy tener poco trabajo");
					break;
				case 7:
					System.out.println(nombre+" tu fortuna de hoy es ver descuentos en la tienda");
					break;
				case 8:
					System.out.println(nombre+" tu fortuna de hoy es obtener un paquete");
					break;
				case 9:
					System.out.println(nombre+" tu fortuna de hoy es la mejor sorpresa de todas");
					break;
					
				}
				
			}

			
		} catch (Exception e) {
			
		}
		
		
	}

}
