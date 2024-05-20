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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void connect(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connect(Vertex<T> origin, Vertex<T> destination, int weight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disconnect(Vertex<T> origin, Vertex<T> destination) {
		for (Vertex<T> v : vertices) {
			
		}		
	}

	@Override
	public boolean existsEdge(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Vertex<T>> getVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int weight(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Edge<T>> getEdges(Vertex<T> v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vertex<T> getVertex(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

}
