package stack;

public class testStack {
	public static void main(String []args){
		//Linked Stack
		Stack<String> strings = new Stack<String>();
		for(int i = 0; i<=10000; i++)
			strings.push(Integer.toString(i));
		//Using for-each with Iterable
		for(String string:strings)
			System.out.println(string);
			
		//Array Stack
		ArrayStack<String> array =  new ArrayStack<String>();
		for(int i = 0; i<=10000; i++)
			array.push(Integer.toString(i));
		for(String string:array)
			System.out.println(string);
	}
}
