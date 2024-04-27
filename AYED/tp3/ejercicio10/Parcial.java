package tp3.ejercicio10;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class Parcial {
	
	 public static List<Integer> resolver(GeneralTree<Integer> arbol){
		 
		 List<Integer> camino = new LinkedList<Integer>();
		 if (arbol != null && !arbol.isEmpty()) {
			 List<Integer> aux = new LinkedList<Integer>();
			 int nivel = 0, calculo_aux = 0;
			 calculoCaminoFiltrado calculoC = new calculoCaminoFiltrado();	//Creo este objeto para que funcione el pasaje por parametros porque no tendria forma de almacenar el valor el calculo propio del camino
			 if (arbol.getData() == 1) aux.add(arbol.getData());
			 resolver_private(arbol,camino,aux,nivel,calculoC,calculo_aux);
		 }
		 
		 return camino;
		 
	 }
	 
	 private static void resolver_private(GeneralTree<Integer> arbol, List<Integer> camino, List<Integer> aux, int nivel, calculoCaminoFiltrado calculoC, int calculo_aux){
		
		 if (arbol.isLeaf()) {
			 
			 if (calculo_aux>calculoC.getCalculo_camino()) {
				 
				 camino.clear();
				 
				 camino.addAll(aux);
				 
				 calculoC.setCalculo_camino(calculo_aux);
				 
			 }
		 }
		 
		 else {
			 
			 List<GeneralTree<Integer>> children = arbol.getChildren();
			 
			 for (GeneralTree<Integer> i : children) {
				 
				if (i.getData() == 1) {
					aux.add(i.getData());
				}
				
				resolver_private(i,camino,aux,nivel+1,calculoC,calculo_aux+i.getData()*nivel);	//Llamo a la recursividad
				//Mando un calculo como calculo_aux porque si lo hago en el IF donde se añade al hijo, estoy acumulando el valor en calculo_aux
				
				if (i.getData() == 1) aux.remove(aux.size()-1);		//Elimino el ultimo elemento de la lista auxiliar pero seguir armandola con los otros hijos
				
			}
		 }
		 
	 }
	 
}
