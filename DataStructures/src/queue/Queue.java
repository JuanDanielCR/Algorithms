package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
	private Node first, last;
	private int n;
	
	public Queue(){
		first = null;
		last = null;
		n = 0;
	}
	//Nested Node Class
	public class Node{
		public Item item;
		public Node next;
	}
	//isEmpty
	public boolean isEmpty(){
		return first == null;
	}
	//getN
	public int getN() {
		return n;
	}
	//peek
	public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }
	//enqueue
	public void enqueue(Item item){
		Node oldlast = last;
		last =  new Node();
		last.item =  item;
		last.next = null;
		if(isEmpty()) first = last;
		else oldlast.next = last;
		n++;
	}
	//dequeue
	public Item dequeue(){
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		Item item = first.item;
		first =  first.next;
		n--;
		if(isEmpty()) last = null;
		return item;
	}
	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}
	public class QueueIterator implements Iterator<Item>{
		private Node current = first;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current =  current.next;
			return item;
		}	
	}
}
