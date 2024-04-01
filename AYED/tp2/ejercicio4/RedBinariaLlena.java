package tp2.ejercicio4;

import tp2.ejercicio1.BinaryTree;

public class RedBinariaLlena {

	BinaryTree<Integer> ab;
	
	public RedBinariaLlena(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	
	//Entre las opciones de recorrido, la mejor es la preOrden porque el codigio resultante es mas legible y son menos las operaciones a realizar.
	
	public int retardoReenvio1() {
		int max = retardoReenvioPreOrden(this.ab);
		return max;
	}
	
	private int retardoReenvioPreOrden(BinaryTree<Integer> ab) {
		if (ab==null || ab.isEmpty() ) {
			return 0;
		}
		else {
			int suma1=ab.getData(), suma2=ab.getData();
			if (ab.hasLeftChild()) suma1+=retardoReenvioPreOrden(ab.getLeftChild());
			if (ab.hasRightChild()) suma2+=retardoReenvioPreOrden(ab.getRightChild());
			if (suma1>suma2) return suma1;
			else return suma2;
		}
	}
	

	public int retardoReenvio2() {
		int max = retardoReenvioPostOrden(this.ab);
		return max;
	}
	
	
	private int retardoReenvioPostOrden(BinaryTree<Integer> ab) {
		if (ab==null || ab.isEmpty()) {
			return 0;
		}
		else {
			int suma1=0, suma2=0;
			if (ab.hasLeftChild()) suma1=retardoReenvioPostOrden(ab.getLeftChild());
			if (ab.hasRightChild()) suma2=retardoReenvioPostOrden(ab.getRightChild());
			suma1 +=ab.getData();
			suma2 += ab.getData();
			if (suma1>suma2) return suma1;
			else return suma2;
		}
	}
	
	public int retardoReenvio3() {
		int max = retardoReenvioInOrden(this.ab);
		return max;
	}
	
	
	private int retardoReenvioInOrden(BinaryTree<Integer> ab) {
		if (ab==null || ab.isEmpty()) {
			return 0;
		}
		else {
			int suma1=0, suma2=0;
			if (ab.hasLeftChild()) suma1+=retardoReenvioInOrden(ab.getLeftChild());
			suma1 +=ab.getData();
			suma2 += ab.getData();
			if (ab.hasRightChild()) suma2+=retardoReenvioInOrden(ab.getRightChild());
			if (suma1>suma2) return suma1;
			else return suma2;
		}
	}
}
