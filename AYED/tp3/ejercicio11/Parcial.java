package tp3.ejercicio11;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1.GeneralTree;

public class Parcial {
	
	 public static boolean resolver(GeneralTree<Integer> arbol) {
		 if (arbol == null) return false;
		 if (arbol.isEmpty()) return true;
		 
		 Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		 GeneralTree<Integer> tree_aux;
		 int nodos_actual = 1, nodos_sig=0;
		 cola.enqueue(arbol);
		 cola.enqueue(null);
		 
		 while(!cola.isEmpty()) {
			 tree_aux = cola.dequeue();
			 if (tree_aux != null) {
				 
				 if (tree_aux.hasChildren()) {
					 for (GeneralTree<Integer> i : tree_aux.getChildren()) {
						cola.enqueue(i);
						nodos_sig++;	//Sumo la cantidad de nodos de cada nivel
					}
				 }
				 
			 }
			 
			 else if (!cola.isEmpty()) {	//No necestio entrar aca despues de procesar las hojas porque NO tienen elementos siguientes
				 cola.enqueue(null);
				 if (nodos_sig != (nodos_actual+1)) return false;	//Si la condicion se cumple, me retorna FALSE. ES decir, que el arbol NO cumple
				 nodos_actual = nodos_sig;	//Actualizo la cantidad de nodos del nivel actual
				 nodos_sig = 0;		//Actualizo para poder seguir contando
			 }
		 }
		 
		 return true;
		 
	 }
	
}
