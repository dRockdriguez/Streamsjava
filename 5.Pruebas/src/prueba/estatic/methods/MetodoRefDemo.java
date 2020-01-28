package prueba.estatic.methods;

import prueba.interfazfuncional.DemoInt;
import prueba.interfazfuncional.OtherDemoInt;

// Métodos estáticos
public class MetodoRefDemo {
	static boolean pruebaNum(DemoInt p, int v) {
		return p.prueba(v);
	}
	
	public static void main(String [] args) {
		boolean res;
		
		res = pruebaNum(MiDemoInt::esPrimo, 2);
		System.out.println(res);
		
		res = pruebaNum(MiDemoInt::esPar, 3);
		System.out.println(res);
		
		res = pruebaNum(MiDemoInt::esPositivo, -3);
		System.out.println(res);
		
		MiDemoInt miNum = new MiDemoInt(15);
		
		DemoInt di = miNum::esDivisor;
		res = di.prueba(3);
		System.out.println(res);
		
		OtherDemoInt odi = MiDemoInt::esDivisor;
		res = odi.prueba(new MiDemoInt(3), 3);
		System.out.println(res);
		
		
	}
}
