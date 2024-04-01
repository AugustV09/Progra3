package tp2.ejercicio3;

import java.util.LinkedList;
import java.util.List;

import tp2.ejercicio1.BinaryTree;

public class ContadorArbol {
	private BinaryTree<Integer> data;
	
	public ContadorArbol(BinaryTree<Integer> data) {
		this.data = data;
	}
	
	public ContadorArbol() {
		
	}
	
	public BinaryTree<Integer> getData(){
		return this.data;
	}
	
	public List<Integer> numerosParesPreOrden(){
		
		List<Integer> numeros = new LinkedList<Integer>();
		numerosParesHelper1(numeros,this.getData());
		return numeros;
		
	}
	
	private void numerosParesHelper1(List<Integer> numeros, BinaryTree<Integer> ab) {
		if ((ab != null) && (!ab.isEmpty())) {
			
			if(ab.getData()%2==0) {
				numeros.add(ab.getData());
			}
			numerosParesHelper1(numeros,ab.getLeftChild());
			numerosParesHelper1(numeros,ab.getRightChild());
			
		}
	}
	
	public List<Integer> numerosParesPostOrden(){
		
		List<Integer> numeros = new LinkedList<Integer>();
		numerosParesHelper2(numeros,this.getData());
		return numeros;
		
	}
	
	private void numerosParesHelper2(List<Integer> numeros, BinaryTree<Integer> ab) {
		if ((ab != null) && (!ab.isEmpty())) {
			
			numerosParesHelper1(numeros,ab.getLeftChild());
			numerosParesHelper1(numeros,ab.getRightChild());
			
			if(ab.getData()%2==0) {
				numeros.add(ab.getData());
			}
		}
	}
}
