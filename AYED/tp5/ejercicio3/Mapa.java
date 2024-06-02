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
	
	
	//1)
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
			if (!marca[pos]) {
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
				if (ciudades.get(ciudades.size()-1).equals(ciudad2)) break; //Si la ultima ciudad es CIUDAD2 corto con el bucle y con el metodo privado
				ciudades.remove(ciudades.size()-1); //Si la ultima ciudad NO es CIUDAD2, elimino el ultimo elemento de la lista  continuo con los siguientes vertices adyacentes
			}
			
		}
		ciudades.remove(ciudades.size()-1); //Si la ultima ciudad NO es CIUDAD2, elimino el ultimo elemento de la lista  continuo con los siguientes vertices adyacentes
		
	}
	
	//2)
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
			
			if (!marca[actual.getPosition()] && !ciudadesNo.contains(actual.getData())) {
				busquedaConDfsExceptuando(ciudades, actual.getPosition(), ciudad2, marca, ciudadesNo);
			}
			
			if (!ciudades.isEmpty()) {
				if (ciudades.get(ciudades.size()-1).equals(ciudad2)) {
					ciudades.remove(ciudades.size()-1);	//Si la ultima ciudad de la lista es CIUDAD2, la remuevo de la lista y termine con el bucle
					break;
				}
				
				else ciudades.clear(); //Limpió la lista del DFS anterior porque la busqueda no resultó
			}
			
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
			
			if (!marca[aux] && !ciudadesNo.contains(e.target().getData())) {
				
				busquedaConDfs(ciudades,aux,ciudad2,marca);
				if (ciudades.get(ciudades.size()-1).equals(ciudad2)) break; //Si la ultima ciudad es CIUDAD2 corto con el bucle y con el metodo privado
				ciudades.remove(ciudades.size()-1); //Si la ultima ciudad NO es CIUDAD2, elimino el ultimo elemento de la lista  continuo con los siguientes vertices adyacentes
			
			}

		}
		
	}
	
	//3)
	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		
		Valores v = new Valores(Integer.MAX_VALUE);
		
		if (ciudad1 == null || ciudad2 == null) return (v.getCaminoMinimo());
		
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		if (origen == null) return (v.getCaminoMinimo());
		Vertex<String> destino = mapaCiudades.search(ciudad2);
		if (destino == null) return (v.getCaminoMinimo());
		
		Valores aux = new Valores(0);
		boolean[] marca = new boolean[mapaCiudades.getSize()];
		List<Edge<String>> aristas = mapaCiudades.getEdges(origen);
		
		for (Edge<String> e : aristas) {
			busquedaDfsCorto(e, v, aux, marca, ciudad2);
			//marca[e.target().getPosition()] = true;	//Esta linea es para que los vertices adyacentes de ciudad1 se mantengan en TRUE y no se repitan recorridos
		}
		
		return (v.getCaminoMinimo());
		
		
	}
	
	private void busquedaDfsCorto(Edge<String> arista, Valores v, Valores aux, boolean[] marca, String ciudad2) {
		
		int pos = arista.target().getPosition();
		Vertex<String> vertice = mapaCiudades.getVertex(pos);
		
		if (vertice.getData().equals(ciudad2)) {
			aux.añadirParada(vertice.getData(), arista.getWeight());
			if (v.getWeight()>aux.getWeight()) {
				aux.eliminarUltimaParada(0);
				v.nuevoCamino(aux.getCaminoMinimo(), aux.getWeight());
			}
			if (!aux.isEmpty()) aux.eliminarUltimaParada(arista.getWeight());
			return;
		}
		
		List<Edge<String>> aristas = mapaCiudades.getEdges(vertice);
		
			
		marca[pos] = true;
		aux.añadirParada(vertice.getData(), arista.getWeight());
			
			
		for (Edge<String> e : aristas) {
				
			if (!marca[e.target().getPosition()]) {
				busquedaDfsCorto(e, v, aux, marca, ciudad2);
					
			}
		}
			
		aux.eliminarUltimaParada(arista.getWeight());
			
		marca[pos] = false;
		
	}
	
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		List<String> ciudades = new LinkedList<String>();
		
		if (ciudad1 == null || ciudad2 == null) return ciudades;
		
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		if (origen == null || mapaCiudades.search(ciudad1) == null) return ciudades;
		
		boolean[] marca = new boolean[mapaCiudades.getSize()];
		BusquedaDfsSinCombustible(origen.getPosition(), ciudad2, tanqueAuto, ciudades, marca);
		return ciudades;
	}
	
	private void BusquedaDfsSinCombustible(int pos, String ciudad2, int tanqueAuto, List<String> ciudades, boolean[] marca) {
		
		Vertex<String> v = mapaCiudades.getVertex(pos);
		ciudades.add(v.getData()); 
		if (ciudades.get(ciudades.size()-1).equals(ciudad2)) return;
		
		marca[pos] = true;
		for (Edge<String> e : mapaCiudades.getEdges(v)) {
			int aux = e.target().getPosition();
			
			if (!marca[aux] && (tanqueAuto - e.getWeight() >= 0) ) {
				BusquedaDfsSinCombustible(aux,ciudad2,tanqueAuto - e.getWeight(), ciudades, marca);
				if (ciudades.get(ciudades.size()-1).equals(ciudad2)) return;
			}
			
		}
		
		ciudades.remove(ciudades.size()-1);
		marca[pos] = false;
		
	}
	
	public List<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto){
		
		ValoresCombustibles v = new ValoresCombustibles(Integer.MAX_VALUE, tanqueAuto);
		
		if (ciudad1 == null || ciudad2 == null) return v.getCiudades();
		
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		if (origen == null || mapaCiudades.search(ciudad2) == null) return v.getCiudades();
		
		boolean[] marca = new boolean[mapaCiudades.getSize()];
		ValoresCombustibles aux = new ValoresCombustibles(0, tanqueAuto);
		BusquedaDfsCortoCombustible(origen.getPosition(), ciudad2,marca, v,aux, tanqueAuto);
		
		return v.getCiudades();
	}
	
	private void BusquedaDfsCortoCombustible(int pos, String ciudad2, boolean[] marca, ValoresCombustibles v, ValoresCombustibles aux, int tanqueAuto) {
		
		Vertex<String> vertice = mapaCiudades.getVertex(pos);
		aux.añadirCiudad(vertice.getData());
		
		if (vertice.getData().equals(ciudad2)) {
			if (v.getCargas() > aux.getCargas()) {
				v.nuevoCamino(aux);
			}
			aux.eliminarUltimaParada();
			return;
		}
		
		marca[pos] = true;
		
		for (Edge<String> e : mapaCiudades.getEdges(vertice)) {
			int posEdge = e.target().getPosition();
			
			if (!marca[posEdge]) {
				if ((aux.getCombustible() - e.getWeight()) < 0) {	//Por si nos quedamos sin combustible y es necesario cargar desde la ciudad donde estamos
					aux.incrementarCargas();	//Se incrementa la cantidad de cargas de combustible
					aux.setCombustible(tanqueAuto);	//Se coloca la nueva cantidad de combustible
				}
				
				aux.modificarCombustible(-e.getWeight());	//Decremento el combustible debido al viaje
				BusquedaDfsCortoCombustible(posEdge, ciudad2, marca,v, aux, tanqueAuto);
				aux.modificarCombustible(e.getWeight());  //Aumento la cantidad de combustible porque vuelvo de la recursividad 
			}
		}
		
		marca[pos] = false; //Desenmarco al vertice para que se utilizable de nuevo
		aux.eliminarUltimaParada();	//Elimino al vertice de la lista
		
	}
}
