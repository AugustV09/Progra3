package tp5.ejercicio6;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class BuscadorDeCaminos{

	private Graph<String> bosque;
	
	public BuscadorDeCaminos(Graph<String> bosque) {
		this.bosque = bosque;
	}
	
	 public List < List <String>> recorridosMasSeguro(){
		 
		 List < List <String>> caminos = new LinkedList<List <String>>();
		 
		 Vertex<String> abuelita = bosque.search("Casa Caperucita");
		 if (abuelita == null) return caminos;
		 
		 boolean[] marca = new boolean[bosque.getSize()];
		 busquedaDfs(abuelita.getPosition(), caminos, marca, "Casa Abuelita");
		 return caminos;
		 
	 }
	 
	 private void busquedaDfs(int pos, List < List <String>> caminos, boolean[] marca, String destino) {
	
	 }
	
}
