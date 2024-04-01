package tp2.ejercicio6;

import tp2.ejercicio1.BinaryTree;

public class Transformacion {

	private BinaryTree<Integer> ab;
	
	public Transformacion(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public BinaryTree<Integer> suma(){
		BinaryTree<Integer> arbol = suma_private(ab);
		return arbol;
	}
	
	
	private BinaryTree<Integer> suma_private(BinaryTree<Integer> arbol) {
		if (arbol == null || arbol.isEmpty()) {
			return null;
		}
		else {
			BinaryTree<Integer> aux = new BinaryTree<Integer>();
			int suma =0;
			if (arbol.hasLeftChild()) {			//CUENTA COMO RECORRER UNA VEZ???
				suma+=arbol.getLeftChild().getData();
				aux.addLeftChild(suma_private(arbol.getLeftChild()));
			}
			if (arbol.hasRightChild()) {		//CUENTA COMO RECORRER UNA VEZ???
				suma+=arbol.getRightChild().getData();			
				aux.addRightChild(suma_private(arbol.getRightChild()));
			}
			
			aux.setData(suma);
			
			return aux;
			
		}
	}
	
	/*No sabria decir si el recorrido del arbol se da dos veces porque con suma solo me quedo con el dato del arbol y sigo con el recorrido, lo cual si hace 
	 * la siguiente linea a cada suma*/
	
}
