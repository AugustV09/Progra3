package tp5.ejercicio5;

import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class QuedateEnCasa {

	public List<Persona> jubiladosPagar (Graph<Persona> personas, Persona empleado, int distancia){
		
		List<Persona> jubilados = new LinkedList<Persona>();
		Vertex<Persona> origen = personas.search(empleado);
		
		if (origen == null) return jubilados;
		
		int llegarDistancia = 0;
		boolean[] marca = new boolean[personas.getSize()];
		Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
		cola.enqueue(origen);
		cola.enqueue(null);
		marca[origen.getPosition()] = true;
		
		while ((!cola.isEmpty()) && (llegarDistancia <= distancia) && (jubilados.size() < 40)) {
			Vertex<Persona> aux = cola.dequeue();
			
			if (aux != null) {
				Persona p = aux.getData();
				
				if (p.isJubilado() && p.debeCobrar()) jubilados.add(p);
				
				if (llegarDistancia < distancia) {	//Sirve para no encolar más PERSONAS una vez se alcance la distancia deseada
					
					for (Edge<Persona> e : personas.getEdges(aux)) {
						int pos = e.target().getPosition();
						
						if (!marca[pos]) {
							marca[pos] = true;
							cola.enqueue(e.target());
						}
					}
					
				}
			}
			
			else if (!cola.isEmpty()) {
				llegarDistancia++;
				cola.enqueue(null);
			}
		}
		
		return jubilados;
		
	}
}
