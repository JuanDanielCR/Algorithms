package test;

import java.util.Random;

import sources.CircularlyLinkedList;

public class TestCircularly {
	public static void main(String args[]){
		CircularlyLinkedList<Integer> list =  new CircularlyLinkedList<>();
		
		Random rand = new Random( ); // a pseudo-random number generator
		rand.setSeed(System.currentTimeMillis( ));
		
		for(long i=0; i<10000000; i++){
			int aux = rand.nextInt(100);
			list.addLast(aux);
		}
		System.out.println(list.getSize());
		list.removeFirst();
		System.out.println(list.getSize());
		list.addFirst(10);
		System.out.println(list.getSize());
		System.out.println("Head: "+list.getFirst());
		list.rotate();
		System.out.println("Rote");
		System.out.println("Tail: "+list.getLast());
		System.out.println("Head: "+list.getFirst());
		list.rotate();
		System.out.println("Rote");
		System.out.println("Tail: "+list.getLast());
	}
}
