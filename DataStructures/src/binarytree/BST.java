package binarytree;

import queue.Queue;

/**
 * Rules:
 * (1) Smaller keys go the left of a node.
 * (2) Greater keys go to the right.
 * */
public class BST <Key extends Comparable<Key>, Value>{
	private Node root;
	//Node class
	public class Node{
		private Key key;
		private Value value;
		private Node left, rigth;
		private int size;
		
		public Node(Key k, Value val){
			key = k;
			value = val;
		}
	}

	//put - recursive
	public void put(Key key, Value value){
		root = put(root,key,value);
	}
	/**recursive, just X node changes until it gets into its position, key and value are always passed with same value
	 * until node is in position, then it uses key, value to be created.
	 * */
	private Node put(Node x, Key key, Value value){
	//recursive break statement => node x is in position and is created
		if(x == null) return new Node(key,value);
	//Comparing the inserted key (always the same), with the value of the key in x, which changes as it swims through the tree
		int cmp = key.compareTo(x.key);
		/**
		 * Inserted key is minor => it goes to the left of x because of (1).
		 * Recursion updates x value, by sending x.left.
		 * put() returns the pointer of a child to its parent, at bottom (end of recursion) the pointer of the new created node
		 * is returned and so recursively until reach the root;
		 * */
		if(cmp < 0) x.left = put(x.left,key,value);
		//Inserted key is major => it goes to the right because of (2)
		else if(cmp > 0) x.rigth = put(x.rigth,key,value);
		//Equals keys, update the value
		else x.value = value;
		/**
		 * When the new Node is created, its time to return the references of the nodes which were used during the recursion
		 * */
		return x;
	}
	//get - note recursive because we dont update the tree, just consult
	public Node get(Key key){
		//Start at root
		Node x = root;
		//Comparing until we get into a lief
		while(x != null){
			//Comparing key inserted with keys in the tree
			int cmp = key.compareTo(x.key);
			if(cmp < 0) x = x.left;
			else if(cmp > 0) x = x.rigth;
			else return x;
		}
		return null;
	}
	/**
	 * Inorder traversal keys in ascending order, use a queue.
	 * We don't implement Iterable because we will return a Queue which is already Iterable.
	 * So just focus on how to fill the queue.
	 */
	public Iterable <Key> keys(){
		Queue<Key> q = new Queue<Key>();
		inorder(root,q);
		return q;
	}
	private void inorder(Node x, Queue<Key>q){
		//recursion break statement
		if(x == null )return;
		//recursion send left until find the smallest
		inorder(x.left,q);
		//When smallest left is reached put it on queue
		q.enqueue(x.key);
		//Now the smallest right... go back o recursion
		inorder(x.rigth,q);
	}
	//Ordered Operations - BST takes constant time in this operations
	public Key floor(Key k){
		Node x = floor(root, k);
		if(x == null) return null;
		else return x.key;
	}
	private Node floor(Node x,Key k){
		if(x == null) return null;
		int cmp = k.compareTo(x.key);
		if(cmp == 0) return x;
		if(cmp < 0) return floor(x.left,k);
		Node t = floor(x.rigth, k);
		if(t != null)return t;
		else return x;
	}
}