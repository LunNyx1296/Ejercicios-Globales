package principal;

public class Trabajador extends Persona {
	private String usuario, contraseña, cargo;

	public Trabajador(String dni, String nombre, String usuario, String contraseña, String cargo) {
		super(dni, nombre);
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.cargo = cargo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String visualizar() {
		return super.visualizar()+" Usuario: "+getUsuario()+" Cargo: "+getCargo();
	}
	
	
}
