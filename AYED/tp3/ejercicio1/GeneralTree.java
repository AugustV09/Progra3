package tp3.ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T> {

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();
	
	public GeneralTree(T data){
		this.data = data;
	}
	
	public GeneralTree(T data, List<GeneralTree<T>> children){
		this.data = data;
		this.children = children;
	}
	
	public GeneralTree(){
		
	}
	
	public T getData(){
		return this.data;
	}
	
	public void setData (T data){
		this.data = data;
	}
	
	public List<GeneralTree<T>> getChildren(){
		return this.children;
	}
	
	public void setChildren (List<GeneralTree<T>> children){
		this.children = children;
	}
	
	public void addChild (GeneralTree<T> child){
		getChildren().add(child);
	}
	
	public boolean hasChildren(){
		return (getChildren()!= null && !getChildren().isEmpty());
	}
	
	public boolean isLeaf(){
		return (!hasChildren());
	}
	
	public boolean isEmpty(){
		return (getData()==null && isLeaf());
	}
	
	public void removeChild(GeneralTree<T> child){
		if (this.hasChildren()){
			getChildren().remove(child);
		}
	}
	
	
	public boolean equals (GeneralTree<T> ga){
		boolean resultado = false;
		
		if (ga!= null){
			if (this.hasChildren() && ga.hasChildren()) {
				if (this.getData().equals(ga.getData()) && this.getChildren().equals(ga.getChildren())) resultado = true;
			}
			else if (!this.hasChildren() && !ga.hasChildren() && this.getData().equals(ga.getData())) resultado = true;
		}
		
		return resultado;
	}
	
}
