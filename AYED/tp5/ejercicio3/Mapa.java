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
		
		if (ciudad1 == null || ciudad2== null) return ciudades;	//Chequeo que podria NO estar
		
		//Chequeos que DEBEN estar para hacer operaciones inecesarias
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		if (origen == null) return ciudades;	
		Vertex<String> destino = mapaCiudades.search(ciudad2);
		if (destino == null) return ciudades;
		
		boolean[] marca = new boolean[mapaCiudades.getSize()]; //Inicializacion del vector de visitados
		List<Edge<String>> aristas = mapaCiudades.getEdges(origen);	//Lista de las aristas de la ciudad origen
		
		for(int i = 0; i<aristas.size(); i++) {
			int pos = aristas.get(i).target().getPosition();
			if (marca[pos]) {
				busquedaConDfs(ciudades, pos, ciudad2, marca);
			}
			if (ciudades.get(ciudades.size()-1).equals(ciudad2)) {
				ciudades.remove(ciudades.size()-1);	//Si la ultima ciudad de la lista es CIUDAD2, la remuevo de la lista y termine con el bucle
				break;
			}
			else ciudades.clear(); //Limpió la lista del DFS anterior porque la busqueda no resultó
		}
		
		return ciudades;
	}
	
	private void busquedaConDfs(List<String> ciudades, int pos, String ciudad2, boolean[] marca) {
		
		Vertex<String> v = mapaCiudades.getVertex(pos);
		marca[pos] = true;
		ciudades.add(v.getData());
		if (v.getData().equals(ciudad2)) return;
		
		for (Edge<String> e : mapaCiudades.getEdges(v)) {
			int aux = e.target().getPosition();
			if (!marca[aux]) {
				busquedaConDfs(ciudades,aux,ciudad2,marca);
			}
			if (ciudades.get(ciudades.size()-1).equals(ciudad2)) break; //Si la ultima ciudad es CIUDAD2 corto con el bucle y con el metodo privado
			ciudades.remove(ciudades.size()-1); //Si la ultima ciudad NO es CIUDAD2, elimino el ultimo elemento de la lista  continuo con los siguientes vertices adyacentes
		}
		
	}
	
	//B)
	public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudadesNo){
		List<String> ciudades = new LinkedList<String>();
		
		if (ciudad1 == null || ciudad2== null) return ciudades;	//Chequeo que podria NO estar
		
		//Chequeos que DEBEN estar para hacer operaciones inecesarias
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		if (origen == null) return ciudades;	
		Vertex<String> destino = mapaCiudades.search(ciudad2);
		if (destino == null) return ciudades;
		
		boolean[] marca = new boolean[mapaCiudades.getSize()]; //Inicializacion del vector de visitados
		List<Edge<String>> aristas = mapaCiudades.getEdges(origen);	//Lista de las aristas de la ciudad origen
		
		for(int i = 0; i<aristas.size(); i++) {
			Vertex<String> actual = aristas.get(i).target();
			if (marca[actual.getPosition()] && !ciudadesNo.contains(actual.getData())) {
				busquedaConDfsExceptuando(ciudades, actual.getPosition(), ciudad2, marca, ciudadesNo);
			}
			if (!ciudades.isEmpty() && ciudades.get(ciudades.size()-1).equals(ciudad2)) {
				ciudades.remove(ciudades.size()-1);	//Si la ultima ciudad de la lista es CIUDAD2, la remuevo de la lista y termine con el bucle
				break;
			}
			else ciudades.clear(); //Limpió la lista del DFS anterior porque la busqueda no resultó
		}
		
		return ciudades;
	}
	
	private void busquedaConDfsExceptuando(List<String> ciudades, int pos, String ciudad2, boolean[] marca, List<String> ciudadesNo) {
		
		Vertex<String> v = mapaCiudades.getVertex(pos);
		marca[pos] = true;
		ciudades.add(v.getData());
		if (v.getData().equals(ciudad2)) return;
		
		for (Edge<String> e : mapaCiudades.getEdges(v)) {
			int aux = e.target().getPosition();
			if (!marca[aux] && !ciudadesNo.contains(e.target())) {
				busquedaConDfs(ciudades,aux,ciudad2,marca);
			}
			if (!ciudades.isEmpty()) {
				if (ciudades.get(ciudades.size()-1).equals(ciudad2)) break; //Si la ultima ciudad es CIUDAD2 corto con el bucle y con el metodo privado
				ciudades.remove(ciudades.size()-1); //Si la ultima ciudad NO es CIUDAD2, elimino el ultimo elemento de la lista  continuo con los siguientes vertices adyacentes
			}
		}
		
	}
}
