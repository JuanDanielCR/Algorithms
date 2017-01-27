package sorts;

import java.util.Random;

public class InsertionSort{
	public void sort(Comparable a[]){
		int N = a.length;
		for(int i = 0; i < N; i++){
			for(int j = i; j > 0; j--){
				if(less(a[j],a[j-1])){
					exch(a,j,j-1);
				}else{
					break;
				}
			}
		}
		assert isSorted(a,0,a.length-1);
	}
	public boolean less(Comparable a, Comparable b){
		return a.compareTo(b) < 0 ;
	}
	public void exch(Comparable[]a, int i, int j){
		Comparable aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}
	public boolean isSorted(Comparable[]a,int lo, int hi){
		for(int i = lo+1; i < hi; i++)
			if(less(a[i],a[i-1])) return false;
		return true;
	}
	
	
	public static void main(String [] args){
		Random rdn =  new Random();
		Integer [] array = new Integer[1000];
		for(int i = 0; i<1000;i++){
			array[i] = rdn.nextInt(1000);
		}
		
		InsertionSort selection =  new InsertionSort();
		selection.sort(array);
		
		for(int i = 0; i<1000;i++){
			System.out.print(array[i]+" ");
		}
	}
}
