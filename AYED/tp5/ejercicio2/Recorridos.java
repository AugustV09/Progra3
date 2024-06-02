package tp5.ejercicio2;

import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Recorridos<T> {
	
	public List<T> DFS(Graph<T> grafo){
		
		if (grafo == null) return null;
		
		List<T> elementos = new LinkedList<T>();
		boolean[] marca = new boolean[grafo.getSize()];
		for(int i=0; i<grafo.getSize(); i++) {
			if (!marca[i]) {
				dfs(i,grafo, marca, elementos);
			}
		}
		return elementos;
	}
	
	private void dfs(int i, Graph<T> grafo, boolean[] marca, List<T> elementos) {
		
		marca[i] = true;
		Vertex<T> v = grafo.getVertex(i);
		elementos.add(v.getData());
		
		for (Edge<T> e : grafo.getEdges(v)) {
			
			int j = e.target().getPosition();
			
			if (!marca[j]) {
				dfs(j,grafo, marca, elementos);
			}
		}
	}
	
	public List<T> BFS (Graph<T> grafo){
		
		if (grafo == null) return null;
		
		List<T> elementos = new LinkedList<T>();
		boolean[] marca = new boolean[grafo.getSize()];
		
		for(int i=0; i<grafo.getSize(); i++) {
			if (!marca[i]) {
				bfs(i, grafo,marca,elementos);
			}
		}
		return elementos;
	}
	
	private void bfs(int i, Graph<T> grafo, boolean[] marca, List<T> elementos) {
		
		marca[i] = true;
		
		Queue<Vertex<T>> cola = new Queue<Vertex<T>>();
		
		cola.enqueue(grafo.getVertex(i));
		while (!cola.isEmpty()) {
			Vertex<T> v = cola.dequeue();
			elementos.add(v.getData());
			for (Edge<T> e : grafo.getEdges(v)) {
				int j = e.target().getPosition();
				if (!marca[j]) {
					marca[j] = true;	//Si no estuviera acá, habria posibilidades de que un vertice posterior encole a un vertice ya encolado porque no estaba en TRUE en la marca
					cola.enqueue(e.target());
				}
			}
			
		}
	}
	
}
