package tp2.ejercicio3;

import java.util.LinkedList;
import java.util.List;

import tp2.ejercicio1.BinaryTree;

public class Prueba {

	public static BinaryTree<Integer> creadordeArbol(){
		
		BinaryTree<Integer> ab=new BinaryTree<Integer>();
		BinaryTree<Integer> aux = ab, aux2 = ab;

		
		for(int i=0; i<50;i++) {
			if (i%2==0) {
				aux.setData(i);
				aux = aux.getLeftChild();
				aux = new BinaryTree<Integer>();
			}
			else {
				aux2.setData(i);
				aux2 = aux2.getRightChild();
				aux2 = new BinaryTree<Integer>();
			}
		}
		
		return ab;
	}
	
public static void creadordeArbol2(BinaryTree<Integer> ab,int i){
		
		if (ab.getData().intValue()<10) {
			i++;
			ab.setData(i);
			ab.addLeftChild(new BinaryTree<Integer>(i));
			ab.addRightChild(new BinaryTree<Integer>(i));
			creadordeArbol2(ab.getLeftChild(),i);
			i++;
			creadordeArbol2(ab.getRightChild(),i);

		}
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> ab= new BinaryTree<Integer>(2);
		ab.addLeftChild(new BinaryTree<Integer>(19));
		ab.addRightChild(new BinaryTree<Integer>(11));

		//creadordeArbol2(ab,0);
		
		ContadorArbol c = new ContadorArbol(ab);
		List<Integer> numeros = c.numerosParesInOrden();

		for (Integer integer : numeros) {
			System.out.println(integer);
		}
		
		System.out.println("\n\n\n");
		
		numeros = c.numerosParesPostOrden();

		for (Integer integer : numeros) {
			System.out.println(integer);
		}
	}

}
