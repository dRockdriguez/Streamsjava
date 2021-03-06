package ejemplo.uno.lambda;

public class Lambda implements MetodoPorDefecto{

	public static void main(String args []) {
		MiNombre nombre = new MiNombre() {
			@Override
			public String miNombre() {
				return "Manolito";
			}
		};
		System.out.println(nombre.miNombre());
		
		// Lambda
		MiNombre nombreLambda = () -> "Manolo Lambda";
		System.out.println(nombreLambda.miNombre());
		
		// Lambda suma
		Suma suma = (a, b) -> a + b;
		System.out.println(suma.suma(2, 3));
		
		Suma suma2 = (a, b) -> {
			System.out.println("Par�metros de entrada: " + a + " y " + b);
			return a + b;
		};
		
		System.out.println(suma2.suma(2, 3));
		
		// M�todo por defecto en interfaz
		Lambda l = new Lambda();
		System.out.println(l.nombre("hola"));
		
		
	}

	@Override
	public void mostrarNombre(String nombre) {
		System.out.println(nombre);
	}
	
}
