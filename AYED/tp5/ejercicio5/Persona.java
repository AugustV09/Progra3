package tp5.ejercicio5;

public class Persona {
	
	private String nombre;
	private String domicilio;
	private boolean state;
	private boolean recibiPago;
	
	public boolean isJubilado() {
		return (this.state);
	}
	
	public boolean debeCobrar() {
		return (this.isJubilado() && this.recibiPago);
	}
	
	
}
