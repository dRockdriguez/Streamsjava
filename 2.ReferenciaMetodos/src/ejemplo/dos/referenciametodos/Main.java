package ejemplo.dos.referenciametodos;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String args []) {
		// Referencias a m�todos estaticos
		Trabajo t = new Trabajo() {
			@Override
			public void accion() {
				User.referenciaMetodoEstatico();
			}			
		};
		t.accion();
		
		// Lambda
		Trabajo t1 = () -> User.referenciaMetodoEstatico();
		t1.accion();
		
		// Referencia a static method
		Trabajo t2 = User::referenciaMetodoEstatico;
		t2.accion();
		
		
		
		
		
		// Referencia a m�todo de instancia
		User u = new User("Manolo");
		Trabajo t3 = ()->u.referenciaMetodoParticular();
		t3.accion();
		
		Trabajo t4 = u::referenciaMetodoParticular;
		t4.accion();
		
		
		// Referencia a un metodo de isntancia de un objeto arbitrario de un tipo particular
		TrabajoString ts = (palabra) -> palabra.toUpperCase();
		TrabajoString ts1 = String::toUpperCase;
		System.out.println(ts.accion("hola"));
		System.out.println(ts1.accion("hola1"));
		
		List<User> users = new ArrayList<>();
		users.add(new User("user1"));
		users.add(new User("user2"));
		users.add(new User("user3"));
		users.add(new User("user4"));
		
		users.forEach(nombre-> {
			nombre.mostrarNombre();
		});
		users.forEach(User::mostrarNombre);
		
		
		
		
		// Referencia a un constructor
		IUser u1 = new IUser() {
			@Override
			public User crear(String nombre) {
				return new User(nombre);
			}
		};
		
		IUser u2 = nombre -> new User(nombre);
		IUser u3 = User::new;
	}
}
