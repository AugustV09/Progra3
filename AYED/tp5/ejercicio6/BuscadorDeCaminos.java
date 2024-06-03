package tp5.ejercicio6;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class BuscadorDeCaminos {

	private Graph<String> bosque;
	private int cantFrutales;
	
	public BuscadorDeCaminos(Graph<String> bosque, int cantFrutales) {
		this.bosque = bosque;
		this.cantFrutales=cantFrutales;
	}
	
	 public List < List <String>> recorridosMasSeguro(){
		 
		 List < List <String>> caminos = new LinkedList<List <String>>();
		 
		 Vertex<String> abuelita = bosque.search("Casa Caperucita");
		 if (abuelita == null) return caminos;
		 
		 List<String> aux = new LinkedList<String>();
		 boolean[] marca = new boolean[bosque.getSize()];
		 busquedaDfs(abuelita.getPosition(), aux, caminos, marca, "Casa Abuelita");
		 return caminos;
		 
	 }
	 
	 private void busquedaDfs(int pos, List<String> aux, List < List <String>> caminos, boolean[] marca, String destino) {
		 
		 Vertex<String> v = bosque.getVertex(pos);
		 aux.add(v.getData());
		 
		 if (v.getData().equals(destino)) {
			 caminos.add(new LinkedList<String>(aux));
			 aux.remove(aux.size()-1);
			 return;
		 }
		 
		 marca[pos] = true;
		 
		 for (Edge<String> e : bosque.getEdges(v)) {
			 int posAux = e.target().getPosition();
			 
			 if (!marca[posAux] && e.getWeight()<this.cantFrutales) {
				 busquedaDfs(posAux, aux, caminos, marca, destino);
			 }
		 }
		 
		 marca[pos] = false;
		 aux.remove(aux.size()-1);
		 
	 }
	
}
