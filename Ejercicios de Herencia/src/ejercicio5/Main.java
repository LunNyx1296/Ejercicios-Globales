package ejercicio5;

public class Main {
	public static void main(String[] args) {
		ProcesadorPagoInternacional proc = new ProcesadorPagoInternacional();
		System.out.println("Validación estricta:");
		System.out.println(proc.validar(6000)); // Falla por validación de la hija System.out.println("\nValidación
												// básica:"); System.out.println(proc.validarBasico(6000)); // Usa
												// validación del padre (pasa) }
	}

}
