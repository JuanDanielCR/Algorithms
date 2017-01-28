package sorts;

import java.util.Random;

public class QuickSort3 {
	public void sort(Comparable[]a){
		ShuffleSort.Shuffle(a);
		sort(a,0,a.length-1);
	}
	private void sort(Comparable[]a, int lo, int hi){
	//Recursive break statement;
		if(hi <= lo) return;
	//Use Comparable outisde from less
		Comparable v = a[lo];
	//Put lt, gt and i pointers
		int i = lo;
		int lt = lo;
		int gt = hi;
	//i moves from lo to hi, until it crosses with gt
		while(i <= gt){
			//comparing always a[lo] with the actual a[i], i will move across the array
			int cmp = a[i].compareTo(v);
			if     (cmp < 0) exch(a,i++,lt++); // v is minor => change with lt
			else if(cmp > 0) exch(a,i++,gt--); //
			else 			 i++; //if equals just move i
		}
	//apply recursion
		sort(a,lo,lt-1);
		sort(a,gt+1,hi);
	}
	public void exch(Comparable[]a, int i, int j){
		Comparable aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}
	
	public static void main(String [] args){
		Random rdn =  new Random();
		int n = 3000; //300 millions, 3 times merge sort capacity  
		Integer [] array = new Integer[n];
		for(int i = 0; i<n;i++){
			array[i] = rdn.nextInt(100);
		}
		System.out.println("filled");
		
		QuickSort3 quick =  new QuickSort3();
		quick.sort(array);
		
		for(int i = 0; i<n;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println("Sorted");
	}
}
