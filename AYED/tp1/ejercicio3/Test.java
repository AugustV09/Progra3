package tp1.ejercicio3;

public class Test {

	public static void main(String[] args) {
		Estudiante[] estudiantes = new Estudiante[2];
		Profesor[] profesores = new Profesor[3];
		
		for(int i = 0; i<estudiantes.length;i++) {
			estudiantes[i] = new Estudiante();
			estudiantes[i].setNombre(""+i);
			estudiantes[i].setApellido(""+i);
			estudiantes[i].setComision(""+i);
			estudiantes[i].setDireccion(""+i);
			estudiantes[i].setEmail("@"+i);
			System.out.println(estudiantes[i].tusDatos());
		}
		
		for(int i = 0; i<profesores.length;i++) {
			profesores[i] = new Profesor();
			profesores[i].setNombre(""+i);
			profesores[i].setApellido(""+i);
			profesores[i].setCatedra(""+i);
			profesores[i].setFacultad(""+i);
			profesores[i].setEmail("@"+i);
			System.out.println(profesores[i].tusDatos());
		}
	}


}
