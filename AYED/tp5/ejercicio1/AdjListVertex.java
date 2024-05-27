package tp5.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class AdjListVertex<T> implements Vertex<T> {

	private T data;
	private int position;
	private List<Edge<T>> edges;
	
	public AdjListVertex(T data, int position) {
		
		this.data = data;
		this.position = position;
		edges = new ArrayList<Edge<T>>();
	}
	
	@Override
	public T getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setData(T data) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getPosition() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<Edge<T>> getEdges(){
		return (new ArrayList<>(this.edges));
	}
	
	public void connect(Vertex<T> target, int weight){
		//COMPLETAR
	}
	
	

}
