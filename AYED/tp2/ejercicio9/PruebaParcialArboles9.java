package tp2.ejercicio9;

import tp2.ejercicio1.BinaryTree;
import tp2.ejercicio7.PruebaParcialArboles7;

public class PruebaParcialArboles9 {

	public static void main(String[] args) {
		BinaryTree<Integer> ab = PruebaParcialArboles7.creadorArboles();
		ParcialArboles p = new ParcialArboles();
		
		ab.entreNiveles(0, 50);
		
		
		System.out.println("\n\n\n\n");
		
		p.sumAndDif(ab).entreNiveles(0, 50);

	}

}
