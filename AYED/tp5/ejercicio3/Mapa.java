package tp5.ejercicio3;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Mapa {

	private Graph<String> mapaCiudades;
	
	public Mapa (Graph<String> m) {
		mapaCiudades = m;
	}
	
	
	//A)
	public List<String> devolverCamino (String ciudad1, String ciudad2){
		List<String> ciudades = new LinkedList<String>();
		
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		if (origen == null) return ciudades;	
		Vertex<String> destino = mapaCiudades.search(ciudad2);
		if (destino == null) return ciudades;
		
		boolean[] marca = new boolean[mapaCiudades.getSize()];
		List<Edge<String>> aristas = mapaCiudades.getEdges(origen);
		for(int i = 0; i<aristas.size(); i++) {
			int pos = aristas.get(i).target().getPosition();
			if (marca[pos]) {
				busquedaConDfs(ciudades, pos, ciudad2, marca);
			}
		}
		
		return ciudades;
	}
	
	private void busquedaConDfs(List<String> ciudades, Vertex<String> origen, String ciudad2, boolean[] marca) {
		
		
		
		
		
		
		
	}
}
