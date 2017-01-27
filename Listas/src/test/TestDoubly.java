package test;
import java.util.Random;

import sources.DoublyLinkedList;
public class TestDoubly {
	public static void main(String args[]){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		
		Random rand = new Random( ); // a pseudo-random number generator
		rand.setSeed(System.currentTimeMillis( ));
		for(long i=0; i<10; i++){
			int aux = rand.nextInt(100);
			list.addFirst(aux);
			System.out.println(aux);
		}
		System.out.println(list.isEmpty());
		/*list.removeLast();
		list.removeFirst();
		list.addLast(666);
		list.addFirst(789);*/
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
	}
}
