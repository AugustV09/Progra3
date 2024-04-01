package tp1.ejercicio5;

public class Valores {

	private static int maximo;  //Si lo creo como estatico, igual puedo modificarlo con los seters de las instancias
	private static int minimo;
	private static double promedio;

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		Valores.maximo = maximo;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		Valores.minimo = minimo;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		Valores.promedio = promedio;
	}

	
	public String toString() {
		return "Valores [maximo=" + maximo + ", minimo=" + minimo + ", promedio=" + promedio + "]";
	}

}
