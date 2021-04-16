
public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {12, 3, 5, 7, 4, 19, 26};
		int k = 3;
		System.out.println(findNthSmallest(arr, k));
	}
	
	// ASSIGNMENT 4 Q-2
	public static int findNthSmallest(int[] arr, int n) {
		return quickSort(arr, 0, arr.length - 1, n);
	}
	
	public static int quickSort(int [] arr, int left, int right, int target) {
		if(target > 0 && target <= right - left + 1) {
			int pos = split(arr, left, right);
			if(pos - left == target - 1) {
				return arr[pos];
			}
			if(pos - left > target - 1) {
				return quickSort(arr, left, pos - 1, target);
			}
			return quickSort(arr, pos + 1, right, target - pos + left - 1);
		}
		return -1;
	}
	
	public static int split(int[]arr, int left, int right) {
		int pivot = arr[right];
		int index = left;
		for(int j = left; j <= right - 1; j++) {
			if(arr[j] <= pivot) {
				int temp = arr[index];
				arr[index] = arr[j];
				arr[j] = temp;
				index++;
			}
		}
		int temp = arr[index];
		arr[index] = arr[right];
		arr[right] = temp;
		return index;
	}
	
	// ASSIGNMENT 5 Q-3
	public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int mid = (right - left) / 2 + left;
            if(arr[mid] < arr[mid + 1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
