package BInary_Search_Tree.MEDIUM;

public class Binary_Search_Tree_Greater_Sum_Tree {
    static int sum;

    public TreeNode bstToGst(TreeNode root) {

        sum = 0;
        sum(root);
        return root;

    }

    public void sum(TreeNode root) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            sum = sum + root.val;
            root.val = sum;
            return;
        }
        sum(root.right);
        sum = sum + root.val;
        root.val = sum;

        sum(root.left);

    }

    class Solution {
        private int sum = 0;

        public TreeNode bstToGst(TreeNode root) {
            if (root != null) {
                bstToGst(root.right); // Traverse the right subtree
                sum += root.val; // Update the sum
                root.val = sum; // Update the current node's value
                bstToGst(root.left); // Traverse the left subtree
            }
            return root;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}