package tp5.ejercicio1;

import java.util.List;

public class AdjListGraph<T> implements Graph<T> {

	private List<AdjListVertex<T>> vertices;
	
	@Override
	public Vertex<T> createVertex(T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeVertex(Vertex<T> vertex) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

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
