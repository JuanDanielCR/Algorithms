package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue <Item> implements Iterable<Item> {
	private Item [] items;
	private int n, first, last;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(){
		items = (Item[]) new Object[2];
		n = 0;
		first = 0;
		last = 0;
	}
	//isEmpty
	public boolean isEmpty(){
		return n == 0; 
	}
	//size
	public int getN() {
		return n;
	}
	//resize
	@SuppressWarnings("unchecked")
	public void resize(int capacity){
		assert capacity >= 0;
		Item[] newest =  (Item[]) new Object[capacity];
		for(int i = 0; i < n; i++)
			newest[i] = items[(first+i)%items.length];
		items =  newest;
		first = 0;
		last =  n;
	}
	//enqueue
	public void enqueue(Item item){
		if(n == items.length)resize(2*items.length);
		items[last++] = item;
		if(last == items.length) last = 0; //last is at the begging
		n++;
	}
	//dequeue
	public Item dequeue(){
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		Item item  = items[first];
		items[first] =  null;
		first++;
		n--;
		if (first == items.length) first = 0;
	    if (n > 0 && n == items.length/4) resize(items.length/2); 
		return item;
	}
	@Override
	public Iterator<Item> iterator() {
		return new QueueArrayIterator();
	}
	public class QueueArrayIterator implements Iterator<Item>{
		private int i = 0;
		@Override
		public boolean hasNext() {
			return i < n;
		}

		@Override
		public Item next() {
			Item item = items[(i + first) % items.length];
			i++;
			return item;
		}
		
	}
}
