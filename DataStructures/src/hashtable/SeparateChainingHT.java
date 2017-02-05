package hashtable;

public class SeparateChainingHT<Key,Value> {
	private int n = 0;
	private Node first;
	public class Node{
		private Key key;
		private Value value;
		private Node next;
	}
	public SeparateChainingHT(){}
	public boolean isEmpty(){
		return n == 0;
	}
	public Value get(Key key){
		if(key == null)  throw new IllegalArgumentException("argument to get() is null"); 
		for(Node x = first; x != null; x = x.next){
			if(key.equals(x.key)) return x.value;
		}
		return null;
	}
}
