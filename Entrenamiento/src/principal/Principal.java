package principal;

import java.time.LocalDate;
import java.util.HashMap;


public class Principal {

	public static void main(String[] args) {
		
		HashMap<String, Entretenimiento> entrenamientos =  new HashMap<String, Entretenimiento>();
		Cliente persona = new Cliente("Aitor","Gartzia",LocalDate.now(),entrenamientos);
		
		persona.setEntrenamientos(LocalDate.now(),"flexiones sin manos",100);
		persona.setEntrenamientos(LocalDate.now(),"5X30",100);
		
		System.out.println(persona.visualizar());
		persona.visualizarEntrenamientos();
	}

}