package sources;
/**
 * Data Structure: Array of N elements
 * Interpretation: Set the id of p's root to the id of q's root
 * */
public class QuickUnion {
	
	protected int ids[];
	//N array accesses
	public QuickUnion(int l){
		ids =  new int[l];
		for(int i = 0; i < ids.length; i++)
			ids[i] = i;
	}
	//Depth of p array accesses
	protected int root(int p){
		while(ids[p]!=p)
			p = ids[p];
		return p;
	}
	//Depth of p array accesses, same as root
	public boolean isConnected(int p, int q){
		return root(p) == root(q);
	}
	//Depth of p array accesses, same as root
	public void union(int p, int q){
		int pRoot = root(p);
		int qRoot = root(q);
		ids[pRoot] = qRoot;
	}
	//Trees can get to tall that could be the same as quick find
}