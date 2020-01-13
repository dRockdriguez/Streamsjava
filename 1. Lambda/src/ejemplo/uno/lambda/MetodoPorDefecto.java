package ejemplo.uno.lambda;

public interface MetodoPorDefecto {
	void mostrarNombre(String nombre);
	
	default String nombre(String nombre) {
		return nombre + " por defecto";
	}
}
