package tp2.ejercicio7;

import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
	
	private BinaryTree<Integer> ab;
	
	public ParcialArboles(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public boolean isLeftTree(int num) {  //Metodo que me piden
		BinaryTree<Integer> aux = buscarRama_private(ab, num);
		if (aux==null) return false;
		else return isLeftTree_private(aux);
	}
	
	
	private BinaryTree<Integer> buscarRama_private(BinaryTree<Integer> arbol,int num){  //Busca el subarbol con el numero del nodo que me mandan
		if (arbol == null || arbol.isEmpty()) return null;
		else {
			if (arbol.getData() == num) return arbol;
			else {
				BinaryTree<Integer> aux = buscarRama_private(arbol.getLeftChild(),num);
				if (aux !=null) {
					if (aux.getData()!=num) {
						aux=buscarRama_private(arbol.getRightChild(),num);
					}
				}
				else {
					aux=buscarRama_private(arbol.getRightChild(),num);
				}
				return aux;
			}
		}
	}
	
	private boolean isLeftTree_private (BinaryTree<Integer> arbol) { //Establezco los diferentes casos
		if (arbol.isLeaf()) {
			return false;
		}
		else if (!arbol.hasLeftChild()) {
			return false;
		}
		else if (!arbol.hasRightChild()) {
			return true;
		}
		else {
			int totalIzq= hijosT(arbol.getLeftChild()), totalDer=hijosT(arbol.getRightChild());
			if (totalIzq>totalDer) return true;
			else return false;
		}
	}
	
	private int hijosT(BinaryTree<Integer> arbol) {  //Si el arbol tiene ambos hijos, utilizo este metodo para contar cuantos subarboles con hijo unico hay
		if (arbol.isLeaf()) return 0;
		else {
			int suma =0;
			if (arbol.hasLeftChild()) {
				if (!arbol.hasRightChild()) suma++;
				suma +=hijosT(arbol.getLeftChild());
			}
			if (arbol.hasRightChild()) {
				if (!arbol.hasLeftChild()) suma++;
				suma+=hijosT(arbol.getRightChild());
				
			}
			return suma;
		}
	}
	
	
	//Es equivalente este ulyimo metodo al anterior o es mejor que me quede con el otro porque es mas legible???
	
	//En el parcial es lo mismo si uso el primero o el segundo???
	
	private int hijosT2(BinaryTree<Integer> arbol) {
		if (arbol.isLeaf()) return 0;
		else {
			int suma =0;
			if (arbol.hasLeftChild()) {
				if (!arbol.hasRightChild()) suma++;
				else suma+=hijosT2(arbol.getRightChild());
				suma +=hijosT2(arbol.getLeftChild());
			}
			else suma++;
			
			return suma;
		}
	}

}
