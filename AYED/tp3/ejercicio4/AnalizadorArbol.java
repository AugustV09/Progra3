package tp3.ejercicio4;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1.GeneralTree;

public class AnalizadorArbol {
	
	/*Para resolver el ejercicio, realizare un recorrido entre niveles ya que considero que es el mas 
	 * efectivo e intuitivo para obtener el promedio de cada nivel e irlos comparando cuando cambio de nivel*/
	
	
	//Se supone que el arbol que llega NO va a ser VACIO ni NULL ya que contiene la estructura de la empresa
	 public int devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol) {
		 int max_promedio = Integer.MIN_VALUE, promedio_act=0, cant=0;
		 GeneralTree<AreaEmpresa> tree_aux;
		 Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		 cola.enqueue(arbol);
		 cola.enqueue(null);
		 while (!cola.isEmpty()) {
			 tree_aux = cola.dequeue();
			 if (tree_aux != null) {
				 cant++;
				 promedio_act += tree_aux.getData().getDemora();
				 if (tree_aux.hasChildren()) {
					 for (GeneralTree<AreaEmpresa> i : tree_aux.getChildren()) {
						cola.enqueue(i);
					}
				 }
			 }
			 else if (!cola.isEmpty()) {
				 promedio_act /= cant;
				 if (promedio_act > max_promedio) max_promedio = promedio_act;
				 cant = promedio_act = 0;
			 }
		 }
		 return max_promedio;
		 
	 }
}
