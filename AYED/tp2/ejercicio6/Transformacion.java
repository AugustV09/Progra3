package tp2.ejercicio6;

import tp2.ejercicio1.BinaryTree;

public class Transformacion {

	private BinaryTree<Integer> ab;
	
	public Transformacion(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public BinaryTree<Integer> suma(){
		
		if (this.ab != null) {
			if (!this.ab.isLeaf()) {
				int izq =0, der =0;
				if (this.ab.hasLeftChild()) izq = suma_private(this.ab.getLeftChild());		//HELPER
				if (this.ab.hasRightChild()) der = suma_private(this.ab.getRightChild());	//HELPER
				this.ab.setData(izq+der);
			}
			else this.ab.setData(0);
		}
		
		return this.ab;  
					
	}
	
	
	private int suma_private(BinaryTree<Integer> arbol) {
		
		int suma = 0;										
		if (arbol.hasLeftChild()) {	
			
			suma+= suma_private(arbol.getLeftChild());

		}
		if (arbol.hasRightChild()) {		

			suma+= suma_private(arbol.getRightChild());
			
		}
		
		arbol.setData(suma);
		
		return (suma+arbol.getData());
			
		
	}
	
	
	
}
