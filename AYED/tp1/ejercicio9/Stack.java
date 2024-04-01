package tp1.ejercicio9;
import java.util.ArrayList;
import java.util.List;
import tp1.ejercicio8.Sequence;


public class Stack<T> extends Sequence{

	private List<T> data;
	
	public Stack() {
		this.data = new ArrayList<T>();
	}
	
	public void push(T dato) {
		data.add(0,dato);
	}
	
	public T pop() {
		return data.remove(0);
	}
	
	public T top() {
		return data.get(0);
	}
	
	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean isEmpty() {
		return (data.size()==0);
	}
	
	@Override
	public String toString() {
		String str = "[";
		for(T t: data) {
			str = str + t.toString() + ", ";
		}
		return (str.substring(0, str.length()-2)+"]");
	}

}
