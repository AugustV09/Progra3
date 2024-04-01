package tp1.ejercicio1;

public class Contadores {

	public static void contador(int a, int b) {
		for (; a <= b; a++) {
			System.out.println(a);
		}
	}

	public static void contador2(int a, int b) {
		while (a <= b) {
			System.out.println(a);
			a++;
		}
	}

	public static void contador3(int a, int b) {
		if (a <= b) {
			System.out.println(a);
			contador3(a + 1, b);
		}
	}

	public static void main(String[] args) {
		contador(1, 10);
		contador2(1, 10);
		contador3(1, 10);
	}

}