package tp2.ejercicio8;

import tp2.ejercicio1.BinaryTree;

public class PruebaParcialArboles8 {

	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(5);
		ab.addLeftChild(new BinaryTree<Integer>(2));
		ab.addRightChild(new BinaryTree<Integer>(3));

		BinaryTree<Integer> ab2 = new BinaryTree<Integer>(5);
		
		ParcialArboles p= new ParcialArboles();
		
		System.out.println(p.esPrefijo(ab, ab2));

	}

}
