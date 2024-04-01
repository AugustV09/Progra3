package tp2.ejercicio1;
import tp1.ejercicio3.Estudiante;

public class PruebaArboles {
	
	public static void main(String[] args) {
		BinaryTree<Estudiante> ab = new BinaryTree<Estudiante>(new Estudiante("Octavio","Isabella Valenzi", "A2","@mail","Patag"));
		ab.addLeftChild(new BinaryTree<Estudiante>(new Estudiante("Guido","Isabella Valenzi", "A3","@mail","Alamp")));
		ab.addRightChild(new BinaryTree<Estudiante>(new Estudiante("Daniel","Isabella Valenzi", "A2"+ "4","@mail","Ushushu")));
		
		
		//System.out.println(ab.toString());
		
		//System.out.println(ab.espejo().toString());
		
		//System.out.println(ab.toString());
		
		ab.entreNiveles(0,5);
	}

}
