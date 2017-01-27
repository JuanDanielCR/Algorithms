package test;

import java.util.Random;

import sources.SinglyLinkedList;

public class TestSingly {
	public static void main(String args[]){
		SinglyLinkedList<Integer> list =  new SinglyLinkedList<>();
		
		Random rand = new Random( ); // a pseudo-random number generator
		rand.setSeed(System.currentTimeMillis( ));
		
		for(long i=0; i<10; i++){
			int aux = rand.nextInt(100);
			list.addLast(aux);
		}

		list.showElements();
		System.out.println("Yeah!");
		
		list.addPosition(9999, 4);
		list.addFirst(666);
		list.addFirst(665);
		list.addFirst(664);
		list.addPosition(10000, 5);
		list.removeFirst();
		list.showElements();
		System.out.println("First: "+list.first());
	}
}
