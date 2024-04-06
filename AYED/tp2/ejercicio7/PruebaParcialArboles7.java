package tp2.ejercicio7;

import tp2.ejercicio1.BinaryTree;

public class PruebaParcialArboles7 {

	public static void añadirDato(BinaryTree<Integer> arbol, int n) {
		if(arbol.isEmpty()) {
			
			arbol.setData(n);
		}		
		else if (arbol.getData() < n) {
			if (!arbol.hasRightChild())
				arbol.addRightChild(new BinaryTree<Integer>());
			añadirDato(arbol.getRightChild(), n);
		} else if (arbol.getData() > n) {
			if (!arbol.hasLeftChild())
				arbol.addLeftChild(new BinaryTree<Integer>());
			añadirDato(arbol.getLeftChild(), n);
		}
	}

	public static BinaryTree<Integer> creadorArboles() {
		int aux = (int) (Math.random() * 50);
		BinaryTree<Integer> b = new BinaryTree<Integer>(aux);

		for (int i = 0; i < 5; i++) {

			añadirDato(b, aux);
			aux = (int) (Math.random() * 100);
		}

		return b;
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> ab = creadorArboles();
		
		ParcialArboles p = new ParcialArboles(ab);
		
		ab.entreNiveles(0, 50);
		
		System.out.println("\n\n\n"+p.isLeftTree(9));
		

	}

}
