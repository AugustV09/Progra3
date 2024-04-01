package tp2.ejercicio1;

import tp1.ejercicio8.Queue;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;

	public BinaryTree(T data) {
		this.data = data;
	}

	public BinaryTree() {

	}

	public BinaryTree<T> getLeftChild() {
		return this.leftChild;
	}

	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean hasLeftChild() {
		return (this.getLeftChild() != null);
	}

	public boolean hasRightChild() {
		return (this.getRightChild() != null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());
	}

	public boolean isEmpty() {
		return (this.isLeaf() && this.getData() == null);
	}
	
	@Override
	public String toString() {
		
		String str=null; //Esta bien hacerlo asi o coloco un ELSE?
		
		if (!this.isEmpty()) {
			str = "["+this.getData().toString()+"]\n";
			if (this.hasLeftChild()) str += this.getLeftChild().toString();
			if (this.hasRightChild()) str += this.getRightChild().toString();
		}
		return str;
	}
	
	public int contarHojas() {
		if (this.isLeaf()) {
			return 1;
		}
		else {
			int aux =0;
			if (this.hasLeftChild()) aux += this.getLeftChild().contarHojas();
			if (this.hasRightChild()) aux += this.getRightChild().contarHojas();
			return aux;
		}
	}
	
	public BinaryTree<T> espejo(){
		
		BinaryTree<T> aux = new BinaryTree<T>(this.getData());
		
		if (!this.isLeaf()){   //Esta bien hacer la condicion asi? Porque si el arbol esta vacio el ELSE devuelve NULL
			
			if (this.hasLeftChild()) aux.addRightChild(this.getLeftChild().espejo());
			if (this.hasRightChild()) aux.addLeftChild(this.getRightChild().espejo());
		}
		
		return aux;
	}
	
	public void entreNiveles (int n,int m) {
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		BinaryTree<T> ab;
		int t =0;
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty() && n<=m) {
			ab = cola.dequeue();		
			if (ab!=null) {
				if (t==n) System.out.print(ab.getData()+"-");
				if (ab.hasLeftChild()) cola.enqueue(ab.getLeftChild());
				if (ab.hasRightChild()) cola.enqueue(ab.getRightChild());
			}
			else if (!cola.isEmpty()) {
				if (t==n) System.out.println();
				cola.enqueue(null);
				t++;
				if (t>n) n++;
			}
		}
	}
	
	
	
}
