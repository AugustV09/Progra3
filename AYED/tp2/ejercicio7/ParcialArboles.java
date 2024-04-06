package tp2.ejercicio7;

import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {

	private BinaryTree<Integer> ab;

	public ParcialArboles(BinaryTree<Integer> ab) {
		this.ab = ab;
	}

	public boolean isLeftTree(int num) {
		BinaryTree<Integer> aux;  //creo el arbol que devolveria

		if (this.ab == null || this.ab.isEmpty()) //Si el arbol que me instancian cumple con esto, el arbol creado va a ser NULL
			aux = null;

		else
			aux = buscarRama_private(ab, num);		//si no, busco la rama

		if ((aux == null) || aux.isLeaf())
			return false;
		else {
			int a = -1, b = -1;
			BinaryTree<Integer> hi = aux.getLeftChild(), hd = aux.getRightChild(); /*Es BUENO hacer esto para no
																					repetir siempre el
																					aux.getHijo()???*/

			if (hi != null)
				a = isLeftTree_private(hi);
			if (hd != null)
				b = isLeftTree_private(hd);

			return a > b;
		}
	}

	/*private BinaryTree<Integer> buscarRama_private(BinaryTree<Integer> arbol,int num){ 
	if (arbol == null || arbol.isEmpty()) return null;
	else {
		if (arbol.getData() == num) return arbol;
		else {
			BinaryTree<Integer> aux = buscarRama_private(arbol.getLeftChild(),num);
			if (aux ==null) {
				aux=buscarRama_private(arbol.getRightChild(),num);
			}
			return aux;
		}
	}
}*/

	private BinaryTree<Integer> buscarRama_private(BinaryTree<Integer> arbol, int num) { // Busca el subarbol con el
																							// numero del nodo que me
																							// mandan
		if (arbol.getData() == num)
			return arbol;
		else {
			BinaryTree<Integer> aux = null;
			if (arbol.hasLeftChild())
				aux = buscarRama_private(arbol.getLeftChild(), num);
			if (aux == null) {
				if (arbol.hasRightChild())
					aux = buscarRama_private(arbol.getRightChild(), num);
			}
			return aux;
		}
	}

	private int isLeftTree_private(BinaryTree<Integer> arbol) {
		int suma = 0;
		if (arbol.hasLeftChild()) {
			if (!arbol.hasRightChild())
				suma++;
			suma += isLeftTree_private(arbol.getLeftChild());
		}
		if (arbol.hasRightChild()) {
			if (!arbol.hasLeftChild())
				suma++;
			suma += isLeftTree_private(arbol.getRightChild());

		}
		return suma;
	}

}
