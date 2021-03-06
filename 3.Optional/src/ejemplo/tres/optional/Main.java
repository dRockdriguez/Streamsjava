package ejemplo.tres.optional;

import java.util.Optional;

public class Main {
	public static void main (String [] args) {
		probarOptional(null);
		orElseOptional();
		
		orElseThrow("Manolo");
	//	orElseThrow(null);
		isPresent(null);
	}
	
	public static void probarOptional(String nombre) {
		
	}
	
	public static void crearOptional() {
		Optional<String> opt = Optional.empty();
		opt.get();
	}
	
	public static void orElseOptional() {
		Optional<String> opt = Optional.ofNullable("Hola");
		Optional<String> opt1 = Optional.of("Hola1");
		
		String n = opt.orElse("default");
		String n1 = opt1.orElse("default");
		
		System.out.println(n);
		System.out.println(n1);
		
	}
	
	public static void orElseThrow(String nombre) {
		Optional<String> opt = Optional.ofNullable(nombre);
		opt.orElseThrow(NullPointerException::new);
		
		String n = opt.get();
		System.out.println(n);
	}
	
	public static void isPresent(String nombre) {
		Optional<String> opt = Optional.ofNullable(nombre);
		System.out.println(opt.isPresent());
	}
}
