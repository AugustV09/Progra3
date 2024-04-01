package tp1.ejercicio5;

public class ArregloValores {

	public static Valores devolucionA(int[] array) {
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, sum = 0;

		for (int valor : array) {
			if (valor < min)
				min = valor;
			if (valor > max)
				max = valor;
			sum += valor;
		}

		Valores v = new Valores();
		v.setMaximo(max);
		v.setMinimo(min);
		v.setPromedio(sum / array.length);
		return v;

	}
	
	public static void devolucionB(int[] array, Valores valores) {
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, sum = 0;

		for (int valor : array) {
			if (valor < min)
				min = valor;
			if (valor > max)
				max = valor;
			sum += valor;
		}

		valores.setMaximo(max);
		valores.setMinimo(min);
		valores.setPromedio(sum / array.length);

	}
	
	public static void devolucionC(int[] array) {
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, sum = 0;

		for (int valor : array) {
			if (valor < min)
				min = valor;
			if (valor > max)
				max = valor;
			sum += valor;
		}
		
		Valores v = new Valores();
		v.setMaximo(max);
		v.setMinimo(min);
		v.setPromedio(sum / array.length);

	}

	public static void main(String[] args) {
		int[] valoresArr = { 1, 2, 99, 7845, 22, 63, 74 };

		Valores v1 = devolucionA(valoresArr);
		System.out.println("Los datos son: " + v1.toString());
		
		Valores v2 = new Valores();
		devolucionB(valoresArr, v2);
		System.out.println("Los datos son: "+ v2.toString());
		
		Valores v3 = new Valores();
		System.out.println("Los datos son: " + v3.toString());
	}

}
