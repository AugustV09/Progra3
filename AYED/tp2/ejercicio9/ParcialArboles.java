package tp2.ejercicio9;

import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {

	public BinaryTree<Valores> sumAndDif(BinaryTree<Integer> arbol){
		if (arbol == null) return null;
		else {
			BinaryTree<Valores> ab = new BinaryTree<Valores>();
			int data1 =0,data2=0;
			sumAndDif_private(arbol,ab,data1,data2);
			return ab;
		}
	}
	
	private void sumAndDif_private(BinaryTree<Integer> arbol,BinaryTree<Valores> ab, int data1,int data2) {
		if (arbol.isEmpty()) {
			return;
		}
		
		else {
			int suma1 = data1 + arbol.getData();
			Valores v = new Valores(data1+arbol.getData(),arbol.getData()-data2);
			ab.setData(v);
			
			if (arbol.hasLeftChild()) {
				ab.addLeftChild(new BinaryTree<Valores>());
				sumAndDif_private(arbol.getLeftChild(),ab.getLeftChild(),suma1,arbol.getData());
			}
			
			if (arbol.hasRightChild()) {
				ab.addRightChild(new BinaryTree<Valores>());
				sumAndDif_private(arbol.getRightChild(),ab.getRightChild(),suma1,arbol.getData());
			}
		}
	}
	
}
