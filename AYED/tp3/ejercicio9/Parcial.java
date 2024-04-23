package tp3.ejercicio9;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1.GeneralTree;

public class Parcial {

	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		
		return esDeSeleccion_private(arbol,arbol.getData());
		
	}
	
	private static boolean esDeSeleccion_private (GeneralTree<Integer> arbol,int raiz) {
		
		if (arbol.hasChildren()) {
			boolean resultado= false;
			int min = Integer.MAX_VALUE;
			
			if (raiz <= arbol.getData()) {
				
				resultado= true;
				
				for (GeneralTree<Integer> i : arbol.getChildren()) {
					resultado = resultado && esDeSeleccion_private(i,arbol.getData());
					if (!resultado) break;
					if (min > i.getData()) min = i.getData();				}
				
			} 
			
			return (resultado && (min == raiz));
		}
		
		return true;
		
	}
	
	public static boolean esDeSeleccion2 (GeneralTree<Integer> arbol) {
		
		//Si el arbol es NULL o VACIO, QUE RETORNO??
		
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		GeneralTree<Integer> tree_aux;
		
		cola.enqueue(arbol);
		
		int min;
		
		while (!cola.isEmpty()) {
			
			tree_aux = cola.dequeue();
			
			if (tree_aux.hasChildren()) {
				min = Integer.MAX_VALUE;
				for (GeneralTree<Integer> i : tree_aux.getChildren()) {
					if (i.getData() < arbol.getData()) return false;
					if (i.getData()< min) min = i.getData();
					cola.enqueue(i);
				}
				
				if (min != tree_aux.getData()) return false;
			}
			
		}
		
		return true;
		
		
	}
	
	
	
	
	
}
