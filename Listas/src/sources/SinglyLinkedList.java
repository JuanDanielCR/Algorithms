package sources;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	public SinglyLinkedList(){}
	
	/**isEmpty returns if size == 0 */
	public boolean isEmpty(){
		return size == 0;
	}
	/**Returns but doesn't remove first element*/
	public E first(){
		if(isEmpty()) return null;
		return head.getElement();
	}
	/**Returns but doesn't remove last element*/
	public E last(){
		if(isEmpty()) return null;
		return tail.getElement();
	}
	/**Add a new head*/
	public void addFirst(E e){
		head =  new Node<E>(e, head);
		if(size == 0)
			tail =  head;
		size++;
	}
	/**Add a new tail*/
	public void addLast(E e){
		Node<E> newest =  new Node<E>(e, null);
		if(isEmpty()){
			head = newest;
		}else{
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}
	/**Add an element into an specific position except for position 1*/
	public void addPosition(E e, int position){
		Node<E> newest =  new Node<E>(e, null);
		Node<E> aux = head;
		int aux_pos = 1;
		if(isEmpty()){
			head = newest;
			tail = head;
		}else{
			if(position<=size && position>0){
				while(aux_pos!=position){
					aux_pos++;
					if(aux_pos!=position)
						aux = aux.next;
				}
				Node<E> siguiente = aux.next;
				aux.next = newest;
				newest.next =  siguiente;
			}else{
				System.out.println("Not a valid position");
			}
		}
		size++;
	}
	/**Remove the first element*/
	public E removeFirst(){
		if(isEmpty()){
			return null;
		}
		E answer = head.getElement();
		head = head.next;
		size --;
		if(size == 0){
			tail = null;
		}
		return answer;
	}
	/**Show all the elements from a list*/
	public void showElements(){
		Node<E> aux;
		aux = head;
		while(aux.next != null){
			System.out.println(aux.getElement());
			aux = aux.getNext();
		}
	}
	/**Nested node*/
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
	/**Overriding equals method*/
	@Override
	public boolean equals(Object o){
		if(o==null)return false;//not null
		if(this.getClass()!=o.getClass())return false; //different classes
		SinglyLinkedList other = (SinglyLinkedList)o; //if same classes, cast th other object to SinglyLinkedList
		if(this.size!=other.size)return false; //same size
		Node walkA = this.head;
		Node walkB = other.head;
		while(walkA != null){
			if(!walkA.getElement().equals(walkB.getElement())) return false; //Comparing each individual element with their own equals method
			walkA = walkA.getNext();
			walkB = walkB.getNext();
		}
		return true; //If everything is correct, they are equal
	}
}
