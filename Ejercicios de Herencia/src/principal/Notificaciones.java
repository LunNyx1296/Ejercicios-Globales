package principal;

public class Notificaciones {

	private String mensaje;

	public Notificaciones(String mensaje) {

		this.mensaje = mensaje;

	}

	public String getMensaje() {

		return mensaje;

	}

	public void enviar() {

		System.out.println("Enviando notificación genérica: " + mensaje);

	}

}