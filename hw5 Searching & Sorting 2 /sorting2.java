// 1. Find K Closest Elements https://leetcode.com/problems/find-k-closest-elements/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>
            ((a, b)-> Math.abs(x-a) == Math.abs(x-b) ? b - a: Math.abs(x-b) - Math.abs(x-a));
        for(int i: arr){
            maxHeap.add(i);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        ArrayList<Integer> res = new ArrayList<>(maxHeap);
        Collections.sort(res);
        return res;
    }
}

//2. Find Intersection of 2 sorted arrays https://leetcode.com/problems/intersection-of-two-arrays/

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

//3. Peak Index in a mountain https://leetcode.com/problems/peak-index-in-a-mountain-array/

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int peakIndex = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                peakIndex = i;
            }
        }
        return peakIndex;
    }
}

//4. Reorganize string https://leetcode.com/problems/reorganize-string/

class Solution {
    public String reorganizeString(String S) {
        char[] input = S.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(char c : input) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((c1,c2) -> {
           return map.get(c2) - map.get(c1); 
        });
        for(char c : map.keySet()) {
            pq.add(c);
        }
        if(pq.isEmpty() || (map.get(pq.peek())*2-1) > input.length) {
            return "";
        } else {
            char[] output = new char[input.length];
            int count=0;
            char c = ' ';
            for(int i=0; i<input.length; i+=2) {
                if(count==0) {
                    c = pq.poll();
                    count = map.get(c);
                }
                output[i] = c;
                count--;
            }
            for(int i=1; i<input.length; i+=2) {
                if(count==0) {
                    c = pq.poll();
                    count = map.get(c);
                }
                output[i] = c;
                count--;
            }
            return new String(output);
        }
    }
}

//5. Count number of 1's in sorted binary array https://www.geeksforgeeks.org/count-1s-sorted-binary-array/

public static int countOnes(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    while(right >= left) {
        int mid = left + (right - left) / 2;
        if((mid == right || arr[mid + 1] == 0) && arr[mid] == 1) {
            return mid + 1;
        }else if(arr[mid] == 1) {
            left = mid + 1;
        }else {
            right = mid - 1;
        }
    }
    return 0;
}