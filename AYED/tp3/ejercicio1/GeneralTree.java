package tp3.ejercicio1;

import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;

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
	
	public int altura() {
		int alt = 0;
		GeneralTree<T> tree_aux;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			tree_aux = cola.dequeue();
			if (tree_aux != null) {
				if (tree_aux.hasChildren()) {
					for (GeneralTree<T> i : tree_aux.getChildren()) {
						cola.enqueue(i);
					}
				}
			}
			else if (!cola.isEmpty()) {
				alt++;
				cola.enqueue(null);
			}
			
		}
		return alt;
	}
	
	public int altura2 () {
		return altura_private(this,0);
		
	}
	
	private int altura_private (GeneralTree<T> a, int altura_actual) {
		int aux,alt_max = 0;
		
		if (a.hasChildren()) {
			for (GeneralTree<T> i : a.getChildren()) {
				aux = altura_private(i,altura_actual+1);
				if (aux>alt_max) {
					alt_max = aux;
				}
			}
			return alt_max;
		}
		return altura_actual;
	}
	
	public int nivel(T dato) {
		int alt = 0;
		if (!this.isEmpty() && dato != null) {
			GeneralTree<T> tree_aux;
			Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
			boolean resultado = true;
			cola.enqueue(this);
			cola.enqueue(null);
			while (!cola.isEmpty() && resultado) {
				tree_aux = cola.dequeue();
				if (tree_aux != null) {
					
					if (this.getData().equals(dato)) resultado = false;
					
					else { //Este ELSE sirve para que el programa no haga el FOR-EACH si ya encontro el dato
						
						if (tree_aux.hasChildren()) {
							for (GeneralTree<T> i : tree_aux.getChildren()) {
								cola.enqueue(i);
							}
						}
					}
				}
				else if (!cola.isEmpty()) {
					alt++;
					cola.enqueue(null);
				}
				
			} 
			if (!cola.isEmpty()) return alt; //Esta linea es para confirmar que se encontro el DATO
			else return -1;	//Si no se encuentra al DATO, devuelve -1
		}
		
		else if (this.isEmpty() && dato == null) return alt;
		else return -1;
	}
	
	public int ancho() {
		int cant_max=Integer.MIN_VALUE,cant=0;
		GeneralTree<T> tree_aux;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			tree_aux = cola.dequeue();
			if (tree_aux != null) {
				cant++;
				if (tree_aux.hasChildren()) {
					for (GeneralTree<T> i : tree_aux.getChildren()) {
						cola.enqueue(i);
					}
				}
			}
			else {
				if (cant > cant_max) cant_max = cant;
				cant = 0;
				if (!cola.isEmpty()) cola.enqueue(null);
			}
			
		}
		return cant_max;
	}
	
}
