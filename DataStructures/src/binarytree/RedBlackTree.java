package binarytree;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
//Color options: red = true, black = false
	private final boolean RED = true;
	private final boolean BLACK = false;
	private Node root;
//Adding color to Node, represents the color of the link with its parent 
	public class Node{
		public Key key;
		public Value value;
		public Node left, right;
		public boolean color;
		
		public Node(Key key, Value value,boolean color){
			this.key = key;
			this.value = value;
			this.color = color;
		}
	}
//Is parent red?	
	private boolean isRed(Node x){
		if(x == null) return false;
		return x.color==RED;
	}
//get() same as BST implementation
	public Value get(Key key){
		Node x = root;
		while(x!=null){
			int cmp = key.compareTo(x.key);
			if(cmp < 0) x = x.left;
			else if(cmp > 0) x = x.right;
			else return x.value;
		}
		return null;
	}
//Basic Operations
	private Node rotateLeft(Node h){ //h is parent node
		assert(isRed(h.right));
		Node x = h.right;
		h.right = x.left;
		x.color =  h.color;
		h.color = RED;
		return x;
	}
	private Node rotateRight(Node h){
		assert(isRed(h.left));
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = RED;
		return x;
	}
	private void flipColors(Node h){
		assert(!isRed(h));
		assert(isRed(h.left));
		assert(isRed(h.right));
		h.left.color = BLACK;
		h.right.color = BLACK;
		h.color = RED;
	}
	/**
	 *Insert:
	 *Use basic operations for equivalence with 2-3 tree
	 *(1) Each time we insert a node, we create it as before and make it RED
	 *(2) A node can't have two red links associated 
	 **/
	public void put(Key key, Value value){
		root = put(root,key,value);
	}
	private Node put(Node x, Key key, Value value){
		if(x == null) return new Node(key,value,RED);
		int cmp = key.compareTo(x.key);
		if(cmp < 0) x.left = put(x.left,key,value);
		else if(cmp > 0) x.right = put(x.right,key,value);
		else x.value = value;
	//Rules:
		//right child is red instead of left child
		if(isRed(x.right) && !isRed(x.left)) x = rotateLeft(x);
		//left child and left grandchild are red
		if(isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
		//two child red
		if(isRed(x.left) && isRed(x.right)) flipColors(x);
		
		return x;
	}
}
