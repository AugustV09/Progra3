package tp3.ejercicio6;

import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class RedDeAguaPotable<T> {
	
	private GeneralTree<T> ag;
	
	public RedDeAguaPotable (GeneralTree<T> ag) {
		this.ag = ag;
	}
	
	public double minimoCaudal(double caudal) {
		 
		if (ag != null && !ag.isEmpty() && caudal >= 0) {
			return (minimoCaudal_private (this.ag, caudal));
		}
		
		return -1;
	 }

	private double minimoCaudal_private (GeneralTree<T> arbol, double caudal) {
		
		double minimo = caudal;
		
		if (arbol.hasChildren()) {
			double aux;
			List<GeneralTree<T>> children = arbol.getChildren();
			for (GeneralTree<T> i : children) {
				aux = minimoCaudal_private(i, caudal/children.size());
				if (aux<minimo) minimo = aux;
			}
		}
		
		return minimo;
		
	}
	
}
