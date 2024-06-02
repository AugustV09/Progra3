package tp5.ejercicio3;

import java.util.LinkedList;
import java.util.List;

public class ValoresCombustibles {
	
	private List<String> ciudades;
	private int cantCargas;
	private int combustible;
	
	public ValoresCombustibles(int aux, int combustible) {
		this.ciudades = new LinkedList<String>();
		this.cantCargas = aux;
		this.combustible = combustible;
	}
	
	public List<String> getCiudades(){
		return (new LinkedList<String>(this.ciudades));
	}
	
	public void nuevoCamino(ValoresCombustibles nuevo) {
		ciudades.clear();
		ciudades.addAll(nuevo.getCiudades());
		this.cantCargas = nuevo.getCargas();
		this.combustible = nuevo.getCombustible();
	}
	
	public void añadirCiudad(String aux) {
		this.ciudades.add(aux);
	}
	
	public void limpiarCamino() {
		this.ciudades.clear();
		this.cantCargas =0;
	}
	
	public void incrementarCargas() {
		this.cantCargas++;
	}

	public void modificarCombustible(int cant) {
		this.combustible += cant;
	}
	
	public void eliminarUltimaParada() {
		this.ciudades.remove(ciudades.size()-1);
	}
	
	public int getCombustible() {
		return combustible;
	}
	
	public void setCombustible (int combustible) {
		this.combustible = combustible;
	}
	
	public int getCargas() {
		return cantCargas;
	}
	
}
