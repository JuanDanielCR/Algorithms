package sorts;

public class BinarySearch {
	//Searchs from data[low] to data[high]
	public static boolean binarySearch(int[]data, int target, int low, int high){
		if(low > high)
			return false;
		else{
			int mid = (low + high)/2;
			if(target == data[mid]){
				return true;
			}else if(target < data[mid]){
				return binarySearch(data, target, low, mid-1);
			}else{
				return binarySearch(data, target, mid+1, high);
			}
		}
	}
	//Binary search with out recursion
	public static boolean loopBinaryS(int []data, int target){
		int low = 0;
		int high = data.length - 1;
		while(low<=high){
			int mid = (low+high)/2;
			if(target == data[mid]){
				return true;
			}else if(target < data[mid]){
				high = mid - 1;
			}else{
				low = mid + 1;
			}
		}
		return false;
	}
}
