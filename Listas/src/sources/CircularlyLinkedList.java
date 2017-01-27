package sources;


public class CircularlyLinkedList<E> {
	private Node<E> tail =  null;
	private int size = 0;
	
	public CircularlyLinkedList(){}
	/**Accesors*/
	public int getSize() {return size;}
	private boolean isEmpty(){return size == 0;}
	public E getFirst() {
		if(isEmpty()) return null;
		return tail.getNext().getElement();
	}
	public E getLast(){
		if(isEmpty()) return null;
		return tail.getElement();
	}
	/**Update Methods*/
	public void rotate(){
		if(tail!=null){
			tail = tail.getNext();
		}
	}
	public void addFirst(E e){
		if(size == 0){
			tail = new Node<E>(e, null);
			tail.setNext(tail);
		}else{
			Node<E> newest = new Node<E>(e, tail.getNext());
			tail.setNext(newest);
		}
		size++;
	}
	public void addLast(E e){
		addFirst(e);		//insert the new element
		tail = tail.getNext(); //as it is the last, we convert it to tail
	}
	public E removeFirst(){
		if(isEmpty())return null;
		Node<E> head = tail.getNext();
		if(head == tail) tail =  null;
		else tail.setNext(head.getNext());
		size --;
		return head.getElement();
	}
	/**Our node nested class*/
	private static class Node<E>{
		private E element;
		private Node<E> next;
		public Node(E element, Node<E> next){
			this.element =  element;
			this.next =  next;
		}
		public E getElement() {
			return element;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
}
