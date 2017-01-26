package sources;
/**
 * Interpretation: Quick Union, which points a node directly to its root after calling root()
 * */
public class PathCompression extends QuickUnion{

	public PathCompression(int l) {
		super(l);
	}
	//Same as Quick Union just modify root() method
	@Override
	protected int root(int p){
		while(ids[p]!=p){
			ids[p] = ids[ids[p]]; //Grandparent
			p = ids[p];
		}
		return p;
	}
}
