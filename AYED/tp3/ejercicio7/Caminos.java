package tp3.ejercicio7;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class Caminos {

	private GeneralTree<Integer> ag;
	
	public Caminos (GeneralTree<Integer> ag) {
		this.ag = ag;
	}
	
	public List<Integer> caminoAHojaMasLejana (){
		
		List<Integer> camino = new LinkedList<Integer>();
		if (ag != null & !ag.isEmpty()) {
			List<Integer> aux = new LinkedList<Integer>();
			aux.add(ag.getData());
			caminoAHojaMasLejana_private(this.ag, camino, aux);
		} 	
		
		return camino;
	}
	
	private void caminoAHojaMasLejana_private(GeneralTree<Integer> ag, List<Integer> camino, List<Integer> aux) {
		
		if (ag.isLeaf()) {
			if (camino.size()<aux.size()) {
				camino.clear();
				camino.addAll(aux);
			}
		}
		
		if (ag.hasChildren()) {
			List<GeneralTree<Integer>> children = ag.getChildren();
			for (GeneralTree<Integer> i : children) {
				aux.add(i.getData());
				caminoAHojaMasLejana_private(i,camino,aux);
				aux.remove(aux.size() - 1);
			}
		}
		
	}
}




