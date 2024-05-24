package tp5.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class AdjMatrixGraph<T> implements Graph<T>{
	
	private static final int EMPTY_VALUE = 0;
	private int maxVertices;
	private List<AdjMatrixVertex<T>> vertices;
	private int[][] adjMatrix;
	
	public AdjMatrixGraph(int maxVert){
		maxVertices = maxVert;
		vertices = new ArrayList<AdjMatrixVertex<T>>();
		adjMatrix = new int [maxVertices][maxVertices];
		//DEBERIA INICIALIZAR LA MATRIZ CON EL VALOR PARA VACIOS????
	}
	
	@Override
	public Vertex<T> createVertex(T data) {
		if (vertices.size() == maxVertices) return null;
		
		AdjMatrixVertex<T> vertice = new AdjMatrixVertex<T>(data, vertices.size());
		vertices.add(vertice);
		return vertice;
	}

	@Override
	public void removeVertex(Vertex<T> vertex) {
		int position = vertex.getPosition();
		if (vertices.get(position) != vertex) {
		//Comparas los vertices directamente con los punteros (porque no se esta haciendo equals) ya que un vertice deberia ser él mismo para que tenga sentido
			return;
		}
		
		vertices.remove(position);
		
		for(int i =0; i<maxVertices; i++) {
			adjMatrix[position][i] = EMPTY_VALUE;
			adjMatrix[i][position] = EMPTY_VALUE;
		}
		
	}

	@Override
	public Vertex<T> search(T data) {
		int i=0;
		while (i<maxVertices) {
			if (vertices.get(i).getData().equals(data)) return (vertices.get(i));
			i++;
		}
		return null;
	}

	@Override
	public void connect(Vertex<T> origin, Vertex<T> destination) {
		//ESTO DA ERROR, como lo hago???
		int posOrigin = origin.getPosition(), posDest = destination.getPosition();
		
		if (vertices.get(posOrigin) == origin && vertices.get(posDest) == destination) {
			adjMatrix[posOrigin][posDest] = EMPTY_VALUE;	//ESTA BIEN?
		}
		
	}

	@Override
	public void connect(Vertex<T> origin, Vertex<T> destination, int weight) {
		int posOrigin = origin.getPosition(), posDest = destination.getPosition();
		
		if (vertices.get(posOrigin) == origin && vertices.get(posDest) == destination) {
			adjMatrix[posOrigin][posDest] = weight;
		}
		
	}

	@Override
	public void disconnect(Vertex<T> origin, Vertex<T> destination) {
		int posOrigin = origin.getPosition(), posDest = destination.getPosition();
		
		if (vertices.get(posOrigin) == origin && vertices.get(posDest) == destination) {
			adjMatrix[posOrigin][posDest] = EMPTY_VALUE;
		}
	}

	@Override
	public boolean existsEdge(Vertex<T> origin, Vertex<T> destination) {
		int posOrigin = origin.getPosition(), posDest = destination.getPosition();
		
		if (vertices.get(posOrigin) == origin && vertices.get(posDest) == destination) {
			return (adjMatrix[posOrigin][posDest] != EMPTY_VALUE);
		}
		
		return false;
	}

	@Override
	public boolean isEmpty() {
		
		return (vertices.size()==0);
	}

	@Override
	public List<Vertex<T>> getVertices() {
		return vertices;	//QUÉ DEBERIA HACER ACA????
	}

	@Override
	public int weight(Vertex<T> origin, Vertex<T> destination) {
		
		int posOrigin = origin.getPosition(), posDest = destination.getPosition();
		
		if (vertices.get(posOrigin) == origin && vertices.get(posDest) == destination) {
			if (adjMatrix[posOrigin][posDest] != EMPTY_VALUE) return adjMatrix[posOrigin][posDest];	
		}
		
		return 0;
	}

	@Override
	public List<Edge<T>> getEdges(Vertex<T> v) {
		
		int pos = v.getPosition();
		
		if (vertices.get(pos) == v) {
			List<Edge<T>> edges = new ArrayList<Edge<T>>();
			for (int i=0; i<maxVertices; i++) {
				if (adjMatrix[pos][i] != EMPTY_VALUE) edges.add(new AdjMatrixEdge<T>(vertices.get(i), adjMatrix[pos][i]));
			}
			
			return edges;
		}
		
		return null;
	}

	@Override
	public Vertex<T> getVertex(int position) {
	
		return vertices.get(position);
	}

	@Override
	public int getSize() {
		
		return vertices.size();
	}

}
