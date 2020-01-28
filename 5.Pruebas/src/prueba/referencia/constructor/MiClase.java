package prueba.referencia.constructor;

public class MiClase {
	private String str;

	public MiClase(String str) {
		this.str = str;
	}

	public MiClase() {
		this.str = "Sin parámetros";
	}
	public String getStr() {
		return str;
	}
}
