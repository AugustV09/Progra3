package tp5.ejercicio3;

import java.util.LinkedList;
import java.util.List;

public class Valores {
	
	private List<String> caminoMinimo;
	private int weight;
	
	public Valores (int weight) {
		this.caminoMinimo = new LinkedList<String>();
		this.weight = weight;
	}
	
	public Valores() {
		
	}
	
	public void nuevoCamino(List<String> aux, int auxWeight) {
		
		this.caminoMinimo.clear();
		this.caminoMinimo.addAll(aux);
		weight = auxWeight;
	}
	
	public void añadirParada(String s, int weight) {
		caminoMinimo.add(s);
		this.weight += weight;
	}
	
	public void eliminarUltimaParada(int weight) {
		this.caminoMinimo.remove(caminoMinimo.size()-1);
		this.weight -= weight;
	}
	
	public void limpiarCamino() {
		caminoMinimo.clear();
		this.weight =0;
	}
	
	public boolean isEmpty() {
		return (caminoMinimo.isEmpty());
	}
	
	public List<String> getCaminoMinimo() {
		return (new LinkedList<String>(this.caminoMinimo));
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
