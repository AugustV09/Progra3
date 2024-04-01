package tp1.ejercicio11;

public class paradasColectivo {

	public static void main(String[] args) {
		/*Usaria un ArrayList de ArrayLists donde cada psocion del primer ArrayList se reefiera a un colectivo y el segundo ArrayList
		 * se refiera a cada parada de ese colectivo. Sino seria un ArrayList de un objeto que contenga informacion del colectivo y otro
		 *ArrayList a las paradas. Pienso en este uso porque la cantidad de colectivos y paradas ya esta definida, por lo cual solo 
		 *importaria el tiempo de acceso y no la insercion o eliminacion*/
		
		/*Si la opcion de antes no cooresponde porque el tiempo de acceso no tiene importancia y sí importa agregar o eliminar 
		 * colectivos/paradas, si utilizaria una LinkedList de LinkedLists de la misma forma que antes usaba el ArrayList de 
		 *ArrayLists*/

		
		/*La mejor opcion es utilizar un ArrayList de Circular Queue porque el colectivo comienza otra vez con 
		 * la linea y recorriendo las mismas paradas*/
	}

}
