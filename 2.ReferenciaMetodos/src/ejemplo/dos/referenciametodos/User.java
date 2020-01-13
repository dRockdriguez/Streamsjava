package ejemplo.dos.referenciametodos;

public class User {
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public User(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public static void referenciaMetodoEstatico() {
		System.out.println("hola desde el método estático");
	}
	
	public void referenciaMetodoParticular() {
		System.out.println("Hola desde el método de instancia");
	}
	
	public void mostrarNombre() {
		System.out.println(this.nombre);
	}
}
