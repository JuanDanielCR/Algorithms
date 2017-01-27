package queue;

public class testQueue {
	public static void main(String []args){
		//Linked Queue
		Queue<Integer> numbers =  new  Queue<Integer>();
		for(int i = 0; i< 10000; i++)
			numbers.enqueue(i);
		for(int i:numbers)
			System.out.println(i);
		
		ArrayQueue<Double> array = new ArrayQueue<Double>();
			for(int i = 0; i< 10000; i++)
				array.enqueue(i+0.5);
			for(double i:array)
				System.out.println(i);
	}
}
