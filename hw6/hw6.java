//1. https://leetcode.com/problems/subtree-of-another-tree/ (Links to an external site.)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
    
    private boolean traverse(TreeNode s, TreeNode t){
        return s != null && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }
    
    private boolean equals(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        
        return (s.val == t.val) && equals(s.left, t.left) && equals(s.right, t.right);
    }
}


//2. https://leetcode.com/problems/asteroid-collision/ (Links to an external site.)

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> left = new Stack<>();

        for(int i: asteroids){
            if(i < 0  && !left.isEmpty() && left.peek() > 0){
                while(!left.isEmpty()&& left.peek() > 0 && left.peek() <  Math.abs(i)){
                   left.pop();
                }
                if(left.isEmpty() || left.peek() < 0 )left.push(i);
                else if(left.peek() > 0 && left.peek() ==  Math.abs(i)) left.pop();
            }else{
                left.push(i);
            }
        }
        
        int[] res = new int[left.size()];
        for(int i = left.size() - 1; i >= 0; i--){
            res[i] = left.pop();
        }
        return res;
    }
}


//3. https://leetcode.com/problems/3sum/ (Links to an external site.)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int index = 0; index < nums.length && nums[index] <= 0; index++){
            if(index == 0 || nums[index - 1] != nums[index]){
                findTwo(nums, index, res);
            }
        }
        return res;
    }
    
    private void findTwo(int[] nums, int index, List<List<Integer>> res){
        int left = index + 1;
        int right = nums.length - 1;
        while(left < right){
            int sum = nums[index] + nums[left] + nums[right];
            if(sum < 0){
                left++;
            }else if(sum > 0){
                right--;
            }else{
                res.add(Arrays.asList(nums[index], nums[left], nums[right]));
                left++;
                right--;
                while(left < right && nums[left] == nums[left - 1]){
                    left++;
                }
            }
        }
    }
}


//4. https://leetcode.com/problems/generate-parentheses/ (Links to an external site.)

class Solution {
    public List<String> generateParenthesis(int n) {
         List result = new ArrayList();
        findAll("(",1,0, result, n);
        return result;
    }
    private void findAll(String curr, int open, int close,List result, int n){

        if(curr.length() == 2*n){
            result.add(curr);
            return;
        }
        if(open<n){
            findAll(curr+"(",open+1,close, result, n);
        }
        if(close<open){
            findAll(curr+")",open,close+1, result, n);
        }
    }
}

//5. https://leetcode.com/problems/reverse-nodes-in-k-group/ (Links to an external site.)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode cur = head;
        while(count < k && cur != null){
            count++;
            cur = cur.next;
        }
        
        if(count == k){
            ListNode reversedHead = reverse(head, k);
            head.next = reverseKGroup(cur, k);
            return reversedHead;
        }
        return head;
    }
    
    private ListNode reverse(ListNode head, int k){
        ListNode newHead = null;
        ListNode cur = head;
        while(k > 0){
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
            k--;
        }
        return newHead;
    }
}