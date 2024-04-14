package tp3.ejercicio2;

import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1.GeneralTree;

public class RecorridosAG {
	
	 public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n){
		 
		 List<Integer> numeros = null;
		 if (a!=null && !a.isEmpty()) {
			 numeros = new LinkedList<Integer>();
			 numerosImparesMayoresQuePreOrden_private(a,n,numeros);
		 }
		 
		 return numeros;
	 }
	 
	 private void numerosImparesMayoresQuePreOrden_private(GeneralTree <Integer> a, Integer n,List<Integer> numeros) {
		 
		 int num = a.getData();
		 
		 if (num%2 != 0) {
			 if (num > n) numeros.add(num);
		 }
		 
		 if (a.hasChildren())	//Me fijo aca si tiene hijos porque puede ser que en la mitad del recorrido haya una hoja con la lista en NULL
			 for (GeneralTree <Integer> i: a.getChildren()) {
				 numerosImparesMayoresQuePreOrden_private(i,n,numeros);
			 }
		 
	 }
	 
	 public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n){
		 
		 List<Integer> numeros = null;
		 if (a!=null && !a.isEmpty()) {
			 numeros = new LinkedList<Integer>();
			 numerosImparesMayoresQueInOrden_private(a,n,numeros);
		 }
		 
		 return numeros;
	 }
	 
	 private void numerosImparesMayoresQueInOrden_private(GeneralTree <Integer> a, Integer n,List<Integer> numeros) {
		 
		 if (a.hasChildren())	//Me fijo aca si tiene hijos porque puede ser que la lista de hijos este en NULL
			 numerosImparesMayoresQueInOrden_private(a.getChildren().get(0), n, numeros);
		 
		 int num = a.getData();
		 
		 if (num%2 != 0) {
			 if (num > n) numeros.add(num);
		 }
		 
		 if (a.hasChildren())	//Me fijo aca si tiene hijos porque puede ser que en la mitad del recorrido haya una hoja con la lista en NULL
			 for (int i = 1; i<a.getChildren().size(); i++) {
				 numerosImparesMayoresQuePreOrden_private(a.getChildren().get(i),n,numeros);
			 }
			 
	 }
	 
	 public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){
		 
		 List<Integer> numeros = null;
		 if (a!=null && !a.isEmpty()) {
			 numeros = new LinkedList<Integer>();
			 numerosImparesMayoresQuePosOrden_private(a,n,numeros);
		 }
		 
		 return numeros;
	 }
	 
	 private void numerosImparesMayoresQuePosOrden_private(GeneralTree <Integer> a, Integer n,List<Integer> numeros) {
		 
		 if (a.hasChildren())	//Me fijo aca si tiene hijos porque puede ser que en la mitad del recorrido haya una hoja con la lista en NULL
			 for (GeneralTree<Integer> i : a.getChildren()) {
				 numerosImparesMayoresQuePosOrden_private(i,n,numeros);
			}
			 
		 int num = a.getData();
		 
		 if (num%2 != 0) {
			 if (num > n) numeros.add(num);
		 }
		 
			 
	 }
	 
	 public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n){
		 
		 List<Integer> numeros = null;
		 if (a!= null && !a.isEmpty()) {
			 numeros = new LinkedList<Integer>();
			 GeneralTree<Integer> aux;
			 Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
			 cola.enqueue(a);
			 while (!cola.isEmpty()) {
				 aux = cola.dequeue();
				 int num = aux.getData();
				 
				 if (num%2 != 0) {
					 if (num > n) numeros.add(num);
				 }
				 
				 if (aux.hasChildren())	//Me fijo aca si tiene hijos porque puede ser que en la mitad del recorrido haya una hoja con la lista en NULL
					 for (GeneralTree<Integer> i : aux.getChildren()) {
						 cola.enqueue(i);
					}
			 }
		 }
		 
		 return numeros;
	 }
	 
	 
	 /*b) Si tuviera que implementar estos recorridos en la clase GeneralTree<T> todas las implementaciones 
	  * serian iguales salvo por recibir el arbol en cada metodo publico. SIn embargo, si seguiria creando
	  * metodos privados para realizar la tarea que me piden*/
}
