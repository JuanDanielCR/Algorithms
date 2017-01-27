package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<Item> implements Iterable<Item>{
	private Item [] items;
	private int n;
	
	//Generic Array casting
	@SuppressWarnings("unchecked")
	public ArrayStack(){
		items =  (Item[]) new Object[2];
		n = 0;
	}
	//API
	public boolean isEmpty(){
		return n == 0;
	}
	//push
	public void push(Item item){
		if(n == items.length) resize(2*items.length);
		items[n++] = item;
	}
	//pop
	public Item pop(){
		Item item = items[--n];
		items[n] = null;
		if(n > 0 && n<items.length/4)
			resize(items.length/2);
		return item;
	}
	//resize
	@SuppressWarnings("unchecked")
	public void resize(int capacity){
		assert capacity >=0;
		Item [] temp = (Item[]) new Object[capacity];
		for(int i=0; i<n; i++)
			temp[i] = items[i];
		items = temp;
	}
	//peek
	public Item peek(){
		if(isEmpty()) throw new NoSuchElementException("Stack underflow");
		return items[n-1];
	}
	//size
	public int getSize() {
		return n;
	}
	@Override
	public Iterator<Item> iterator() {
		return new ReverseIterator();
	}
	public class ReverseIterator implements Iterator<Item>{
		private int i = n-1;
		@Override
		public boolean hasNext() {
			return i >= 0;
		}
		@Override
		public Item next() {
			return items[i--];
		}
		
	}
}
