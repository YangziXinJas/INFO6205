//  1. Find out if a Tree is Balanced. ( Tree is balanced if for every node difference between height of left and right is <=1) https://leetcode.com/problems/balanced-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null){
                return true;
            }
            if (Math.abs(findHeight(root.left) - findHeight(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right)){
                return true;
            }
                return false;
        
            
        }
        private int findHeight(TreeNode root){
            if (root == null){
                return -1;
            }
            return 1 + Math.max(findHeight(root.left), findHeight(root.right));
        }
    }



---------------------------------------------------------------------------------------------------------------------------------------



// 2. Find Minimum depth of all the leaves in a tree. https://leetcode.com/problems/minimum-depth-of-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
        public int minDepth(TreeNode root) {
            if(root == null){
                return 0;
            }
            
            if(root.left == null && root.right == null){
                return 1;
            }
            
            if(root.left == null){
                return minDepth(root.right) + 1;
            }
            if(root.right == null){
                return minDepth(root.left) + 1;
            }
            return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
        }
    }



---------------------------------------------------------------------------------------------------------------------------------------



// 3. Print all the leaves of a tree.  https://leetcode.com/problems/find-leaves-of-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            findHeight(root, res);
            return res;
        }
        
        private int findHeight(TreeNode node, List<List<Integer>> res) {
            if (node == null) {
                return -1;
            }
            int left = findHeight(node.left, res);
            int right = findHeight(node.right, res);
            int height = Math.max(left, right) + 1;
            if (res.size() == height){
                res.add(new ArrayList<>());
            } 
            res.get(height).add(node.val);
            return height;
    
        }
    }



---------------------------------------------------------------------------------------------------------------------------------------



// 4. Print sum of all the left leaves. https://leetcode.com/problems/sum-of-left-leaves/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            int result = 0;
            result = helper(root, result);
            return result;
        }
        
        private int helper(TreeNode root, int result){
            if(root != null && root.left != null && root.left.right == null && root.left.left == null){
                result += root.left.val;
            }
            
            if(root != null ){
                if(root.left != null) {
                    result = helper(root.left, result);
                }
                if(root.right != null){
                    result = helper(root.right, result);
                } 
            }
            return result;
    
        }
    }