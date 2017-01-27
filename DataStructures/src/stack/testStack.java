package stack;

public class testStack {
	public static void main(String []args){
		Stack<String> strings = new Stack<String>();
		for(int i = 0; i<=10000; i++)
			strings.push(Integer.toString(i));

		//Using for-each with Iterable
		for(String string:strings)
			System.out.println(string);
			
	}
}
