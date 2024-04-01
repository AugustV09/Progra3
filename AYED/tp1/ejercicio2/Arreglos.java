package tp1.ejercicio2;

import java.util.Scanner;

public class Arreglos {

	public static int[] dameArreglos(int n) {
		int[] multiplos = new int[n];

		for (int i = 0; i < n; i++) {
			multiplos[i] = n * (i + 1);
		}

		return multiplos;

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int indice = s.nextInt();
		int[] arreglo = dameArreglos(indice);
		for (int i = 0; i < arreglo.length; i++) {
			System.out.println(arreglo[i]);
		}

		s.close();
	}

}
