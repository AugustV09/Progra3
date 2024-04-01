package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import tp1.ejercicio3.Estudiante;

public class TestArrayList {

	public static int[] generadorNumeros() {
		int[] arreglo = new int[2];
		Scanner s = new Scanner(System.in);

		for (int i = 0; i < arreglo.length; i++) {
			System.out.println("Ingrese un numero: ");
			;
			arreglo[i] = s.nextInt();
			s.nextLine();
		}
		s.close();
		return arreglo;

	}

	public static void crearEstudiante() {
		List<Estudiante> estudiantes = new LinkedList<Estudiante>();
		for (int i = 0; i < 3; i++) {
			estudiantes.add(new Estudiante());
		}

		List<Estudiante> estudiantes2 = new LinkedList<Estudiante>(estudiantes);

		for (int i = 0; i < estudiantes.size(); i++) {
			System.out.println(estudiantes.get(i).tusDatos());
			System.out.println(estudiantes2.get(i).tusDatos());

		}

		estudiantes.get(0).setNombre("Pepe");
		estudiantes2.get(1).setApellido("Gomez");

		for (int i = 0; i < estudiantes.size(); i++) {
			System.out.println(estudiantes.get(i).tusDatos());
			System.out.println(estudiantes2.get(i).tusDatos());

		}

		/*Copiar los datos con el addAll hace que ls colecciones referencien al mismo
		objeto, por lo cual las modificaciones se ven reflejadas para ambos*/
		
		/*Copiar clases utilizando el constructor hace que ambas colecciones apunten a
		los mismos objetos estudiantes y la modificacion en uno se ve reflejada para
		ambos*/
		
		// clone() no pude probarlo porque no me lo permite Java

		/*Por ahora, no hay diferencia en el resultado dado por el metodo addAll y por
		la copia hecha por el constructor*/

		
		Estudiante e = new Estudiante();
		e.setNombre("Pepe");
		
		if (!(estudiantes.contains(e))){
			estudiantes.add(e);
		}
		else System.out.println("Si esta en la lista");
	}

	public static boolean esCapicua(List<Integer> lista) {
		boolean resultado = true;
		int ini = 0, fin = lista.size() - 1;

		while ((resultado) && (fin > ini)) {
			if (lista.get(ini++) != lista.get(fin--))
				resultado = false;

		}

		return resultado;

	}
	
	public static void invertirArrayList (ArrayList<Integer> lista) {
		if (lista.size()>1) return;
		else {
			int a = lista.remove(0);
			invertirArrayList(lista);
			lista.add(a);
		}
	}

	public static int sumarLinkedList (LinkedList<Integer> lista) {
		if (lista.isEmpty()) return 0;
		else {
			return (lista.remove(0) + sumarLinkedList(lista));
			
		}
		
	}
	
	public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer>lista1, 
			ArrayList<Integer>lista2){
		
		if ((lista1.isEmpty()) && (lista2.isEmpty())) {   //CASO BASE
			ArrayList<Integer> resultado = new ArrayList<Integer>();
			return resultado;  
		}
		
		else {
			int a = lista1.isEmpty()? lista2.remove(0):lista2.isEmpty()?lista1.remove(0): lista1.get(0)>lista2.get(0)?lista2.remove(0):lista1.remove(0);
			ArrayList<Integer> resultado = combinarOrdenado(lista1,lista2);
			resultado.add(0,a);
			return resultado;
		}
	}
	
	/*public static ArrayList<Integer> combinarOrdenado2(ArrayList<Integer>lista1, 
			ArrayList<Integer>lista2){
		
		if ((lista1.isEmpty()) && (lista2.isEmpty())) {   //CASO BASE
			ArrayList<Integer> resultado = new ArrayList<Integer>();
			return resultado;  
		}
		
		else if ((lista1.isEmpty()) || (lista2.isEmpty())) {
			int a = lista1.isEmpty()? lista2.remove(0):lista1.remove(0);
			ArrayList<Integer> resultado = combinarOrdenado(lista1,lista2);
			resultado.add(0,a);
			return resultado;
		}
		
		
		else {   //Normalmente se ejecutaria este caso
			
			int a = lista1.get(0)>lista2.get(0)?lista2.remove(0):lista1.remove(0); //Me quedo con el elemento mas pequeño
			ArrayList<Integer> resultado = combinarOrdenado(lista1,lista2);
			resultado.add(0,a);
			return resultado;
			
		}
	}*/
	
	public static void main(String[] args) {
		int[] arreglo = generadorNumeros();

		/* INICIO A) */
		List<Integer> numeros = new ArrayList<Integer>();
		for (int i = 0; i < arreglo.length; i++) {
			numeros.add(arreglo[i]);
		}

		for (Integer i : numeros) {
			System.out.println(i);
		}

		/* FIN A) */

		/* INICIO B) */
		List<Integer> numerosLista = new LinkedList<Integer>();

		Iterator<Integer> it = numerosLista.iterator(); // Sirve como un for each

		for (int numero : arreglo) {
			numerosLista.add(numero);
		}

		for (Integer i : numerosLista) {
			System.out.println(i);
		}

		/* FIN B) */

		/* INICIO C) */

		/*Otra forma de recorrer los elementos del 7a es con el Iterador, mediante un
		while o mediante una estructura for convencional*/

		/* FIN C) */

		/* INICIO D) y E) */

		crearEstudiante();

		/* FIN D) y E) */

		/* INICIO F) */
		EjercicioSucesion ejercicio7f = new EjercicioSucesion();
		List<Integer> sucesion = ejercicio7f.calcularSucesion(19);

		for (Integer i : sucesion) {
			System.out.println(i);
		}

		/* FIN F) */
		
		/*INICIO H)*/
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		for(int i = 0; i<4;i++) {
			lista.add(i);
		}
		
		invertirArrayList(lista);
		
		for (Integer i : lista) {
			System.out.println(i);
		}
		
		/*FIN H)*/

		/*INICIO I)*/
		
		LinkedList<Integer> listaNum = new LinkedList<Integer>(lista);
		System.out.println(sumarLinkedList(listaNum));
		
		/*FIN I)*/
		
		/*INICIO J)*/
		ArrayList<Integer> lista1 = new ArrayList<Integer>();
		ArrayList<Integer> lista2 = new ArrayList<Integer>();

		for(int i = 0; i<=10;i++) {
			lista1.add(2*i);

		}
		
		lista2.add(1);
		lista2.add(3);
		
		ArrayList<Integer> listaResultado = combinarOrdenado(lista1,lista2);
		
		for (Integer i : listaResultado) {
			System.out.println(i);
		}

		/*FIN J)*/
	}

}
