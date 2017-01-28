package sorts;

import java.util.Random;

public class QuickSort {
	public void sort(Comparable []a){
		ShuffleSort.Shuffle(a);
		sort(a,0,a.length-1);
	}
	private void sort(Comparable[]a, int lo, int hi){
	//break recursion statement
		if(hi <= lo) return;
	//found mid like in binary and merge, but using partition
		int mid = partition(a,lo,hi);
	//Apply recursion
		sort(a,lo,mid-1);
		sort(a,mid+1,hi);
	}
	private int partition(Comparable[]a, int lo, int hi){
	//put pointers i,j in position
		int i = lo;
		int j = hi+1;
		while(true){
		//increment i until a[i]>a[lo]
			while(less(a[++i],a[lo]))
				if(i==hi)break; //stop at border hi
		//decrement j until a[j]<a[lo]
			while(less(a[lo],a[--j]))
				if(j==lo)break;
		//loops will make a[i] > a[lo] and a[j]<a[lo] so, swap them, unless i and j are crossed
			if(i >= j) break;
			exch(a,i,j);
		}
		//exchange j with lo
		exch(a,lo,j);
		//return j, which divides the array in new subarrays
		return j;
	}
	public boolean less(Comparable a, Comparable b){
		return a.compareTo(b) < 0;
	}
	public void exch(Comparable[]a,int i, int j){
		Comparable aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}
	
	//Test
		public static void main(String [] args){
			Random rdn =  new Random();
			int n = 300000000; //300 millions, 3 times merge sort capacity  
			Integer [] array = new Integer[n];
			for(int i = 0; i<n;i++){
				array[i] = rdn.nextInt(100);
			}
			System.out.println("filled");
			
			QuickSort quick =  new QuickSort();
			quick.sort(array);
			
			System.out.println("Sorted");
		}
}
