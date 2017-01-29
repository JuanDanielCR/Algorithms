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
}
