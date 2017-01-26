package sources;

/**
 * Data Structure: Integer array of length N
 * Interpretation: Objects p and q are connected if they have the same ID
 * QuickFind uses a constant time for isConnected(), use it when the program requires to review if elements are connected lots of times
 * */
public class QuickFind {
	
	private int ids[];
	
	public QuickFind(int l){
		ids =  new int[l];
		for(int i = 0; i < ids.length; i++)
			ids[i] = i;
	}
	//2 array accesses- O(k) constant time
	public boolean isConnected(int p, int q){
		return ids[p] == ids[q];
	}
	//2N+2 array accesses at most
	public void union(int p, int q){
		int pid = ids[p];
		int qid = ids[q];
		for(int i = 0; i < ids.length; i++)
			if(ids[i] == pid)
				ids[i] = qid;
	}	
}