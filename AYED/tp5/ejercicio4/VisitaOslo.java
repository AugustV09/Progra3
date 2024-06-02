package tp5.ejercicio4;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class VisitaOslo {

	 public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos){
		 
		 List<String> ciudades = new LinkedList<String>();
		 
		 if (destino == null || lugares.search(destino) == null) return ciudades;
		 
		 int pos = lugares.search("Ayuntamiento").getPosition();  //Asumo que ayunatmiento existe
		 boolean[] marca = new boolean[lugares.getSize()];
		 busquedaDfs(pos, destino, maxTiempo, lugaresRestringidos, marca, ciudades, lugares);
		 return ciudades;
		 
	 }
	 
	 private void busquedaDfs (int pos, String destino, int maxTiempo, List<String> lugaresRestringidos, boolean[] marca, List<String> ciudades, Graph<String> lugares) {
		 
		 Vertex<String> vertice = lugares.getVertex(pos);
		 ciudades.add(vertice.getData());
		 
		 if (vertice.getData().equals(destino)) return;
		 
		 marca[pos] = true;
		 
		 for (Edge<String> e : lugares.getEdges(vertice)) {
			Vertex<String> v = e.target();
			
			if (!marca[v.getPosition()] && !lugaresRestringidos.contains(v.getData()) && (maxTiempo - e.getWeight()) >= 0) {
				busquedaDfs(v.getPosition(), destino, maxTiempo - e.getWeight(), lugaresRestringidos, marca, ciudades, lugares);
				if (ciudades.get(ciudades.size()-1).equals(destino)) return;
			}
		}
		 
		marca[pos] = false;
		ciudades.remove(ciudades.size()-1); 
	 }
	
}
