package BINARY_TREE.MEDIUM;

//https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        // Call the recursive function and update maxcount directly
        return solve(root, root.val, root.val);
    }

    public int solve(TreeNode root, int min, int max) {
        if (root == null) {
            return max - min;
        }
        // Update min and max values encountered so far
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        // Recursively find the maximum ancestor difference in left and right subtrees
        int leftDiff = solve(root.left, min, max);
        int rightDiff = solve(root.right, min, max);
        // Return the maximum difference found in subtrees
        return Math.max(leftDiff, rightDiff);
    }
}
