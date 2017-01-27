package sorts;

import java.util.Random;

public class SelectionSort {
	private SelectionSort(){ }
	public void sort(Comparable []a){
		int N = a.length;
		for(int i = 0; i<N; i++){
			int min = i;
			for(int j = i+1; j<N; j++){
				if(less((a[j]),a[min]))
					min = j;
			}
			exch(a,i,min);
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
		
		SelectionSort selection =  new SelectionSort();
		selection.sort(array);
		
		for(int i = 0; i<1000;i++){
			System.out.print(array[i]+" ");
		}
	}
}
