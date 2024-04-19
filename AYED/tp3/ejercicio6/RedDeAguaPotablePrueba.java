package tp3.ejercicio6;

import java.util.LinkedList;

import tp3.ejercicio1.GeneralTree;

public class RedDeAguaPotablePrueba {

	public static void main(String[] args) {
		GeneralTree<Integer> ag = new GeneralTree<Integer>(0, new LinkedList<GeneralTree<Integer>>());
		ag.addChild(new GeneralTree<Integer>(2));
		ag.addChild(new GeneralTree<Integer>(2));
		ag.addChild(new GeneralTree<Integer>(2));
		ag.addChild(new GeneralTree<Integer>(2));
		ag.getChildren().get(0).addChild(new GeneralTree<Integer>(2));  //Agrego hijo al hijo mas izquierdo de la raiz
		ag.getChildren().get(0).addChild(new GeneralTree<Integer>(2));
		ag.getChildren().get(0).addChild(new GeneralTree<Integer>(2));
		RedDeAguaPotable<Integer> r = new RedDeAguaPotable<Integer>(ag);
		System.out.println(r.minimoCaudal(1000));
	}

}
