package tp2.ejercicio6;

import tp2.ejercicio1.BinaryTree;

public class Transformacion {

	private BinaryTree<Integer> ab;
	
	public Transformacion(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public BinaryTree<Integer> suma(){
		BinaryTree<Integer> arbol = new BinaryTree<Integer>();
		
		if (suma_private(ab, arbol) == 0) arbol = null;;		//HELPER
																//Que deberia hacer con el entero final que me devuelve???
		
		return arbol;
	}
	
	
	private int suma_private(BinaryTree<Integer> arbol, BinaryTree<Integer> arbol2) {
		if (arbol == null) {
			return 0;
		}
		
		else if (arbol.isLeaf()) {
			arbol2.setData(0);
			return -1;
		}
		
		else {
			
			int suma = arbol.getData();			//podria simplificarlo pero deberia hacer un casteo, ESTARIA BIEN????
			if (arbol.hasLeftChild()) {	
				
				arbol2.addLeftChild(new BinaryTree<Integer>());
				suma+= suma_private(arbol.getLeftChild(),arbol2.getLeftChild());

			}
			if (arbol.hasRightChild()) {		

				arbol2.addRightChild(new BinaryTree<Integer>());
				suma+= suma_private(arbol.getRightChild(),arbol2.getRightChild());
				
			}
			
			arbol2.setData(suma-arbol.getData());
			
			return suma;
			
		}
		
	}
	
	
	
}
