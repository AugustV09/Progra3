package tp2.ejercicio5;

import tp1.ejercicio8.Queue;
import tp2.ejercicio1.BinaryTree;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> ab;
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	 public int sumaElementosProfundidad (int p) {
		 Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		 cola.enqueue(ab);
		 cola.enqueue(null);
		 int suma =0;
		 while ((!cola.isEmpty()) && p>=0) {
			 ab = cola.dequeue();
			 if (ab!= null) {
				 suma += ab.getData();
				 if (ab.hasLeftChild()) cola.enqueue(ab.getLeftChild());
				 if (ab.hasRightChild()) cola.enqueue(ab.getRightChild());
			 }
			 else if (!cola.isEmpty()) {
				 p--;
				 cola.enqueue(null);
			 }
		 }
		 
		 return suma;
	 }
	
}
