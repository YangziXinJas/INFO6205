// 1. Find intersection of 2 unsorted arrays https://leetcode.com/problems/intersection-of-two-arrays/solution/ (Links to an external site.)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int ptr1 = 0;
        int ptr2 = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while(ptr1 < nums1.length && ptr2 < nums2.length){
            int left = nums1[ptr1];
            int right = nums2[ptr2];
            if(left == right){
                res.add(left);
                while(ptr1 < nums1.length && nums1[ptr1] == left){
                    ptr1++;
                }
                while(ptr2 < nums2.length && nums2[ptr2] == right){
                    ptr2++;
                }
                continue;
            }
            if(right > left){
                while(ptr1 < nums1.length && nums1[ptr1] == left){
                    ptr1++;
                }
            }else{
                while(ptr2 < nums2.length && nums2[ptr2] == right){
                    ptr2++;
                }
            }
        }
        int [] ret = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            ret[i] = res.get(i);
        }
        return ret;
    }
}

// 2. Find nth Smallest of an unsorted array. https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/ (Links to an external site.) 

public static int findNthSmallest(int[] arr, int n) {
    if(n > arr.length) {
        System.out.println("invalid input");
        return -1;
    }
    Arrays.sort(arr);
    return arr[n - 1];
}

// 3. Sort colors https://leetcode.com/problems/sort-colors/ (Links to an external site.)

class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        
        int temp;
        while(cur <= right){
            if(nums[cur] == 0){
                temp = nums[left];
                nums[left] = nums[cur];
                nums[cur] = temp;
                left++;
                cur++;
            }else if(nums[cur] == 2){
                temp = nums[cur];
                nums[cur] = nums[right];
                nums[right] = temp;
                right--;
                
            }else{
                cur++;
            }
        }
    }
}

// 4. Pancake sort https://leetcode.com/problems/pancake-sorting/ (Links to an external site.) 

class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res=new ArrayList<>();
        
        int end = arr.length-1;
        
        for(int i=0;i<arr.length;i++){
            int maxIndex = findMax(arr, end);
            //means the array has been exhausted and all elements are sorted
            if(maxIndex == -1) break;
            
            flip(arr, maxIndex);
            res.add(maxIndex+1);
            
            flip(arr, end);
            res.add(end+1);
            
            end--;
        }

        
        return res;
    }
    
    public void flip(int nums[], int end){
        int i=0;
        int j=end;
        
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
    
    public int findMax(int nums[], int end){
        int index=-1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=end;i++){
            if(nums[i] > max){
                index=i;
                max=nums[i];
            }
        }
        
        return index;
    }
}