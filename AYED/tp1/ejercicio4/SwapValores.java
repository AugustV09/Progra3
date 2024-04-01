package tp1.ejercicio4;

public class SwapValores {
	public static void swap1(int x, int y) {
		if (x < y) {
			int tmp = x;
			x = y;
			y = tmp;
		}
	}

	public static void swap2(Integer x, Integer y) {
		if (x < y) {
			int tmp = x;
			x = y;
			y = tmp;
		}
	}

	public static void main(String[] args) {
		int a = 1, b = 2;
		Integer c = 3, d = 4;
		swap1(a, b); //a=1 y b=2
		swap2(c, d); //c=3 y d=4 porque c y d son wrappers y son inmutables
		System.out.println("a=" + a + " b=" + b);  //a=1 y b=2
		System.out.println("c=" + c + " d=" + d);  //c=3 y d=4
		
		
	}
}

