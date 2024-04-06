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
	
	public List<Integer> numerosParesInOrden(){
		
		List<Integer> numeros = new LinkedList<Integer>();
		if ((this.getData() != null) && !(this.getData().isEmpty()))
			numerosParesHelper1(numeros,this.getData());		//HELPER
		return numeros;
		
	}
	
	private void numerosParesHelper1(List<Integer> numeros, BinaryTree<Integer> ab) {  //Es InOrden porque la raiz se procesa en el medio
			
		if (ab.hasLeftChild()) numerosParesHelper1(numeros,ab.getLeftChild());
		if(ab.getData()%2==0) {
			numeros.add(ab.getData());
		}
		if (ab.hasRightChild()) numerosParesHelper1(numeros,ab.getRightChild());
			
	}
	
	public List<Integer> numerosParesPostOrden(){
		
		List<Integer> numeros = new LinkedList<Integer>();
		if ((this.getData() != null) && !(this.getData().isEmpty()))
			numerosParesHelper2(numeros,this.getData());		//HELPER
		return numeros;
		
	}
	
	private void numerosParesHelper2(List<Integer> numeros, BinaryTree<Integer> ab) {  //Es PostOrden porque la raiz se procesa al final

		if (ab.hasLeftChild()) numerosParesHelper1(numeros,ab.getLeftChild());
		if (ab.hasRightChild()) numerosParesHelper1(numeros,ab.getRightChild());
		
		if(ab.getData()%2==0) {
			numeros.add(ab.getData());
		}
	}
}
