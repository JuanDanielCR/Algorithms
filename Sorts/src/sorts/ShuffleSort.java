package sorts;

import java.util.Random;

public class ShuffleSort {
	public static void Shuffle(Object[]a){
		int N = a.length;
		Random rdn =  new Random();
		for(int i = 0; i<N; i++){
			 int rand = i + (int) (Math.random() * (N - i));
			Object aux = a[rand];
			a[rand] = a[i];
			a[i] = aux;
		}
	}
	
	public static void main(String [] args){
		Random rdn =  new Random();
		Integer [] array = new Integer[1000];
		for(int i = 0; i<1000;i++)
			array[i] = rdn.nextInt(1000);
		
		InsertionSort selection =  new InsertionSort();
		selection.sort(array);
		
		for(int i = 0; i<1000;i++)
			System.out.print(array[i]+" ");
		
		System.out.println("");
		System.out.println("Shuffling");
		
		Shuffle(array);
		for(int i = 0; i<1000;i++)
			System.out.print(array[i]+" ");
	}
}
