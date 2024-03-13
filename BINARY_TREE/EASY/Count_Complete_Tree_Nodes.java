package BINARY_TREE.EASY;
//https://www.youtube.com/watch?v=2XTXL7a6ItI&list=PLpIkg8OmuX-K23LhcamOcDlTBisiNJy5E&index=14

//https://leetcode.com/problems/count-complete-tree-nodes/description/

//new method with 
//time complexity longn*2

class Solution {
    public int countNodes(TreeNode root) {
        return solve(root);
    }

    public static int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getleft(root);
        int right = getright(root);

        if (left == right) {
            // and for perfect binary tree the left and right (including them selfs) are
            // equal
            // if the tree is perfect binary tree 2^h-1 is the total number of nodes
            return ((int) Math.pow(2, left)) - 1;
        }

        return solve(root.left) + solve(root.right) + 1;
    }

    public static int getleft(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getleft(root.left) + 1;

    }

    public static int getright(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getright(root.right) + 1;

    }
}
