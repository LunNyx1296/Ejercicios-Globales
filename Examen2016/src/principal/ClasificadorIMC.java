package principal;

class ClasificadorIMC {
    public static String clasificacion(float imc) {
        if (imc < 16.00f) return "Infrapeso: Delgadez Severa";
        if (imc < 17.00f) return "Infrapeso: Delgadez moderada";
        if (imc < 18.50f) return "Infrapeso: Delgadez aceptable";
        if (imc < 25.00f) return "Peso Normal";
        if (imc < 30.00f) return "Sobrepeso";
        if (imc < 35.00f) return "Obeso: Tipo I";
        if (imc <= 40.00f) return "Obeso: Tipo II";
		return "Obeso: Tipo III";
	}
}

