package principal;

import principal.RFID.ControlAccesos;


public class main {
	public static void main(String[] args) {
		ControlAccesos control = new ControlAccesos();

		control.registrarOActualizar("ABC123", "Juan Pérez", "IT", 4);
		control.registrarOActualizar("XYZ789", "Ana López", "HR", 2);

		control.registrarOActualizar("ABC123", "Juan P. Actualizado", "Seguridad", 5);

		control.verificarAcceso("ABC123", 3);
		control.verificarAcceso("XYZ789", 3);
		control.verificarAcceso("NOEXISTE", 1);

		System.out.println("=== Tarjetas registradas ===");
		control.mostrarTarjetas();

		control.revocarTarjeta("XYZ789");
		System.out.println("=== Tras revocar XYZ789 ===");
		control.mostrarTarjetas();
	}
}
