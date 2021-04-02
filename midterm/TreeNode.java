public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
    
    }

    /**
     * Question 2:
     *      Time Complexity: O(# of TreeNodes)
     *      Space Complexity: O(1)
     */
    public void printPerimeter(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val);
        rightBoundary(root.right);
        printLeaves(root.right);
        printLeaves(root.left);
        leftBoundary(root.left);
        System.out.println();
    }

    public void printLeaves(TreeNode n){
        if(n == null){
            return;
        }
        
        if(n.left == null && n.right == null){
            System.out.print(", "+ n.val);
        }
        printLeaves(n.right);
        printLeaves(n.left);
    }

    public void rightBoundary(TreeNode n){
        if(n == null){
            return;
        }
        if(n.left == null && n.right == null){
            return;
        }
        System.out.print(", "+ n.val);
        if(n.right != null){
            rightBoundary(n.right);
        }else if(n.left != null){
            rightBoundary(n.left);
        }
    }

    public void leftBoundary(TreeNode n){
        if(n == null){
            return;
        }
        if(n.left == null && n.right == null){
            return;
        }
        if(n.right != null){
            leftBoundary(n.left);
        }else if(n.left != null){
            leftBoundary(n.right);
        }
        System.out.print(", "+ n.val);
    }
}
