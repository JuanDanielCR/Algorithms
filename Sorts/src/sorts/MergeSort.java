package sorts;

import java.util.Random;

public class MergeSort {
	//sort initialize for create aux[]
	public void sort(Comparable a[]){
		Comparable [] aux =  new Comparable[a.length];
		sort(a,aux,0,a.length-1);
	}
	//sort
	public void sort(Comparable []a, Comparable[] aux, int low, int hi){
	//break statement
		if(hi <= low) return ;
	//Get middle element as in Binary Search
		int mid = (hi+low)/2;
	//First apply recursion by left of halves
		sort(a,aux,low,mid);
		sort(a,aux,mid+1,hi);
	//Finally merge all
		merge(a,aux,low,mid,hi);
	}
	//merge
	public void merge(Comparable []a, Comparable[] aux, int low, int mid, int hi){
		assert isSorted(a,low,mid);
		assert isSorted(a,mid+1,hi);
		//copy to aux
		for(int i = low; i<= hi; i++)
			aux[i] = a[i];
		//i,j pointers for halves
		int i = low;
		int j =  mid+1;
		for(int k=low; k<=hi;k++){
			//Validate one of the 2 halves is fully used
			if     (i > mid) 		     a[k] = aux[j++];
			else if(j > hi) 		     a[k] = aux[i++];
			else if(less(aux[i],aux[j])) a[k] = aux[i++];
			else                         a[k] = aux[j++];
		}
		assert isSorted(aux, low,hi);
	}
	private boolean isSorted(Comparable []a, int lo, int hi){
		for(int i = lo+1; i<=hi; i++ )
			if(less(a[i],a[i-1])) return false;
		return true;
	}
	private boolean less(Comparable a, Comparable b){
		return a.compareTo(b)<0;
	}

	public void exch(Comparable[]a, int i, int j){
		Comparable aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}
	
	//Test
	public static void main(String [] args){
		Random rdn =  new Random();
		int n = 100000000; //100 millions in 2 minutes, need more memory for java to continue 
		Integer [] array = new Integer[n];
		for(int i = 0; i<n;i++){
			array[i] = rdn.nextInt(100);
		}
		System.out.println("filled");
		
		MergeSort merge =  new MergeSort();
		merge.sort(array);
		
		
		System.out.println("Sorted");
	}
}
