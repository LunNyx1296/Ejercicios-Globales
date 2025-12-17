package principal;

import java.util.HashMap;
import java.util.Map;

public class RFID {

	public static final class TarjetaRFID {
		private final String codigoRFID;
		private String nombreEmpleado;
		private String departamento;
		private int nivelAcceso;

		public TarjetaRFID(String codigoRFID, String nombreEmpleado, String departamento, int nivelAcceso) {
			validarCodigo(codigoRFID);
			validarNivel(nivelAcceso);
			this.codigoRFID = codigoRFID;
			this.nombreEmpleado = nombreEmpleado;
			this.departamento = departamento;
			this.nivelAcceso = nivelAcceso;
		}

		public String getCodigoRFID() {
			return codigoRFID;
		}

		public String getNombreEmpleado() {
			return nombreEmpleado;
		}

		public String getDepartamento() {
			return departamento;
		}

		public int getNivelAcceso() {
			return nivelAcceso;
		}

		public void setNombreEmpleado(String nombreEmpleado) {
			this.nombreEmpleado = nombreEmpleado;
		}

		public void setDepartamento(String departamento) {
			this.departamento = departamento;
		}

		public void setNivelAcceso(int nivelAcceso) {
			validarNivel(nivelAcceso);
			this.nivelAcceso = nivelAcceso;
		}

		private static void validarCodigo(String codigo) {
			if (codigo == null || codigo.isBlank()) {
				throw new IllegalArgumentException("El código RFID no puede estar vacío.");
			}
		}

		private static void validarNivel(int nivel) {
			if (nivel < 1 || nivel > 5) {
				throw new IllegalArgumentException("El nivel de acceso debe estar entre 1 y 5.");
			}
		}

		@Override
		public String toString() {
			return "Código: " + codigoRFID + ", Nombre: " + nombreEmpleado + ", Departamento: " + departamento
					+ ", Nivel: " + nivelAcceso;
		}
	}

	public static final class ControlAccesos {
		private final Map<String, TarjetaRFID> tarjetas = new HashMap<>();

		public void registrarOActualizar(String codigoRFID, String nombreEmpleado, String departamento,
				int nivelAcceso) {
			TarjetaRFID existente = tarjetas.get(codigoRFID);
			if (existente == null) {
				TarjetaRFID nueva = new TarjetaRFID(codigoRFID, nombreEmpleado, departamento, nivelAcceso);
				tarjetas.put(codigoRFID, nueva);
			} else {
				existente.setNombreEmpleado(nombreEmpleado);
				existente.setDepartamento(departamento);
				existente.setNivelAcceso(nivelAcceso);
			}
		}

		public boolean verificarAcceso(String codigoRFID, int nivelZona) {
			if (nivelZona < 1 || nivelZona > 5) {
				throw new IllegalArgumentException("El nivel de la zona debe estar entre 1 y 5.");
			}
			TarjetaRFID tarjeta = tarjetas.get(codigoRFID);
			if (tarjeta == null) {
				System.out.println("Acceso denegado: tarjeta no registrada.");
				return false;
			}
			if (tarjeta.getNivelAcceso() >= nivelZona) {
				System.out.println("Acceso permitido.");
				return true;
			} else {
				System.out.println("Acceso denegado: nivel insuficiente.");
				return false;
			}
		}

		public boolean revocarTarjeta(String codigoRFID) {
			return tarjetas.remove(codigoRFID) != null;
		}

		public void mostrarTarjetas() {
			if (tarjetas.isEmpty()) {
				System.out.println("No hay tarjetas registradas.");
				return;
			}
			tarjetas.values().forEach(System.out::println);
		}
	}
}
