public class Solution {
    
    public static void main(String[] args){
        /**
         * Question 1:
         *      Time Complexity: O(length of n1 + length of n2)
         *      Space Complexity: O(length of n1)
         */
        
         // edge case
        ListNode n1 = null;
        ListNode n2 = new ListNode(1);
        System.out.println("Null pointer test case:\n expected: false  actual: " +
            n2.areConverging(n1, n2));

        // general case
        n1 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = n1;
        System.out.println("Regular test case:\n expected: true  actual: " +
             n1.areConverging(n1, n2));

        /**
         * Question 2:
         *      Time Complexity: O(# of TreeNodes)
         *      Space Complexity: O(1)
         */
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right.left = new TreeNode(14);
        root.right.left.right = new TreeNode(13);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(11);
        root.left.right.left = new TreeNode(10);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(9);
        root.left.left.left = new TreeNode(8);
       
        root.printPerimeter(root);

        /**
         * Question 3:
         *      Time Complexity: O(length of array)
         *      Space Complexity: O(1)
         */ 
        int[] arr = {0,1,0,1,1,0,1,1,1,0,0,0};
        System.out.println(getMaxConsecutiveOnes(arr));

        /**
         * Question 4:
         *      Time Complexity: O(log n)
         */
        int[] ar = {2,4,4,4,6,7,7,7,8,9,9,9};
        System.out.println(getIndex(ar, 7));
    }

    /**
     * Question 3:
     *      Time Complexity: O(length of array)
     *      Space Complexity: O(1)
     */ 
    public static int getMaxConsecutiveOnes(int[] nums){
        if(nums == null){
            return 0;
        }
        int max = 0;
        int count = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == 0){
                count = 0;
            }else{
                count += 1;
                max = Math.max(count, max);
            }
        }
        return max;
    }

    /**
     * Question 4:
     *      Time Complexity: O(log n)
     *      Space Complexity: O(1)
     */
    public static int getIndex(int[] nums, int x){
        if(nums == null){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(x == nums[mid]){
                result = mid;
                right = mid - 1;
            }else if (x > nums[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return result;
    }
}
