package sources;

/**
 * Data Structure: Array of N elements, array of N elements which keeps the size of each tree
 * Interpretation: Quick Union algorithm, which add the smaller tree into the larger
 * */

public class QuickUnionWeighted{
	
	private int ids[];
	private int sz[];
	
	public QuickUnionWeighted(int l){
		ids =  new int[l];
		sz =  new int[l];
		for(int i = 0; i < ids.length; i++){
			ids[i] = i;
			sz[i] = 1;
		}
	}
	
	public int root(int p){
		while(ids[p]!=p)
			p = ids[p];
		return p;
	}
	
	public boolean isConnected(int p, int q){
		return root(p) == root(q);
	}
	//Depth of any node is at most lg N, where lg = log base 2
	public void union(int p, int q){
		int pRoot = root(p);
		int qRoot = root(q);
		if(pRoot == qRoot) return ; //Same component
		if(sz[pRoot] < sz[qRoot]){
			ids[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];//Resize
		}else{
			ids[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];//Resize
		}
	}
}
