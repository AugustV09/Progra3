package tp1.ejercicio7;

import java.util.LinkedList;
import java.util.List;

public class EjercicioSucesion {

	public List<Integer> calcularSucesion(int n) {

		if (n == 1) {
			List<Integer> sucesion = new LinkedList<Integer>();
			sucesion.add(n);
			return sucesion;
			
		} else if (n % 2 == 0) {
			List<Integer> sucesion = calcularSucesion(n/2);
			sucesion.add(0, n);
			return sucesion;
			
		} else {
			List<Integer> sucesion = calcularSucesion((3*n)+1);
			sucesion.add(0, n);
			return sucesion;
		}

	}
	
	public List<Integer> calcularSucesion2(int n) {

		if (n == 1) {
			List<Integer> sucesion = new LinkedList<Integer>();
			sucesion.add(n);
			return sucesion;
			
		} else {
			List<Integer> sucesion = (n % 2 == 0)? calcularSucesion(n/2): calcularSucesion((3*n)+1);
			sucesion.add(0, n);
			return sucesion;
		}

	}

}