package principal;

public class EmailNotificacion extends Notificaciones {

    private String direccionEmail;

    public EmailNotificacion(String mensaje, String direccionEmail) {
        super(mensaje);
        this.direccionEmail = direccionEmail;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando email a: " + direccionEmail + " con el mensaje: " + getMensaje());
    }
}