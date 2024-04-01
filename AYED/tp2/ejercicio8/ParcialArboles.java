package tp2.ejercicio8;

import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
	
	 public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		 if (arbol1 == null && arbol2 == null) return true;			//Primero aplico los posibles casos de corte de control y luego evaluo el caso mas comun
		 
		 else if (arbol1 == null || arbol2 == null) return false;
		 
		 else if (arbol1.isEmpty() && arbol2.isEmpty()) return true;
		 
		 else if (arbol1.isEmpty() || arbol2.isEmpty()) return false;
		 
		 else {
			 boolean resultado = true;
			 
			 if (arbol1.getData()!= arbol2.getData()) resultado = false;
			 
			 if (resultado) {
				 if (arbol1.hasLeftChild() && arbol2.hasLeftChild()) resultado = esPrefijo(arbol1.getLeftChild(),arbol2.getRightChild());
				 else if (arbol1.hasLeftChild() && !arbol2.hasLeftChild()) resultado =false;
				 if (resultado) {
					 if(arbol1.hasRightChild() && arbol2.hasRightChild()) resultado = esPrefijo(arbol1.getRightChild(), arbol2.getRightChild());
					 else if(arbol1.hasRightChild() && !arbol2.hasRightChild()) resultado = false;
				 }
			 }
			 
			 
			 return resultado;
		 }
	 }
}