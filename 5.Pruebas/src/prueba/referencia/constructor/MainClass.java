package prueba.referencia.constructor;

public class MainClass {
	public static void main(String[] args) {
		MiFunc f = MiClase::new;

		MiClase c = f.func("hola");
		System.out.println(c.getStr());

		MiFuncSinParametros f1 = MiClase::new;
		MiClase c1 = f1.func();
		System.out.println(c1.getStr());
	}
}
