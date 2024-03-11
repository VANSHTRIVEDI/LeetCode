package BInary_Search_Tree.Easy;

//https://leetcode.com/problems/minimum-absolute-difference-in-bst/
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

class Solution {
    TreeNode prev = null;
    int minsum = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMinimumDifference(root.left);
        if (prev != null) {
            int p = (int) root.val - (int) prev.val;
            minsum = p < minsum ? p : minsum;
            prev = root;
        } else {
            prev = root;
        }

        getMinimumDifference(root.right);

        return minsum;

    }
}
