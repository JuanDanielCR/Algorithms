package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item>{
	private Node first;
	private int size;
	
	public Stack(){
		first = null;
		size = 0;
	}
	//Nested Node Class
	public class Node{
		public Item item;
		public Node next;
	}
	//API
	public boolean isEmpty(){
		return first == null;
	}
	public void push(Item item){
		Node old = first;
		first = new Node();
		first.item = item;
		first.next = old;
		size++;
	}
	public Item pop(){
		Item item = first.item;
		first = first.next;
		size--;
		return item;
	}
	public Item peek(){
		if(isEmpty()) throw new NoSuchElementException("Stack underflow");
		return first.item;
	}
	public int getSize() {
		return size;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	public class ListIterator implements Iterator<Item>{
		private Node current = first;
		public boolean hasNext(){
			return current != null;
		}
		public Item next(){
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}
