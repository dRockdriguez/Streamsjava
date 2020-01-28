package prueba.estatic.methods;

public class MiDemoInt {
	private int x;

	public int getX() {
		return x;
	}

	public MiDemoInt(int x) {
		this.x = x;
	}

	boolean esDivisor(int n) {
		return (x % n) == 0;
	}

	static boolean esPrimo(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i < n / i; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	static boolean esPar(int n) {
		return (n % 2 == 0);
	}

	static boolean esPositivo(int n) {
		return n > 0;
	}
}
