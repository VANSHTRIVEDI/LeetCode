package BINARY_TREE.EASY;

import java.util.*;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/
class Min {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 1;
        while (!q.isEmpty()) {
            int k = q.size();
            for (int i = 0; i < k; i++) {
                if (q.peek().left == null && q.peek().right == null)
                    return count;
                if (q.peek().left != null)
                    q.add(q.peek().left);
                if (q.peek().right != null)
                    q.add(q.peek().right);
                q.poll();
            }
            count++;
        }
        return count;
    }
}

class Min2 {
    public int minDepth(TreeNode root) {
        // Base case...
        // If the subtree is empty i.e. root is NULL, return depth as 0...
        if (root == null)
            return 0;
        // Initialize the depth of two subtrees...
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        // If the both subtrees are empty...
        if (root.left == null && root.right == null)
            return 1;
        // If the left subtree is empty, return the depth of right subtree after adding
        // 1 to it...
        if (root.left == null)
            return 1 + rightDepth;
        // If the right subtree is empty, return the depth of left subtree after adding
        // 1 to it...
        if (root.right == null)
            return 1 + leftDepth;
        // When the two child function return its depth...
        // Pick the minimum out of these two subtrees and return this value after adding
        // 1 to it...
        return Math.min(leftDepth, rightDepth) + 1; // Adding 1 is the current node which is the parent of the two
                                                    // subtrees...
    }
}

class Min3 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        return solve(root);
    }

    public int solve(TreeNode root) {
        // Base case...
        // If the subtree is empty i.e. root is NULL, return depth as 0...
        if (root == null)
            return Integer.MAX_VALUE;
        // Initialize the depth of two subtrees...
        int leftDepth = solve(root.left);
        int rightDepth = solve(root.right);
        // If the both subtrees are empty...
        if (root.left == null && root.right == null)
            return 1;

        return Math.min(leftDepth, rightDepth) + 1; // Adding 1 is the current node which is the parent of the two
                                                    // subtrees...
    }
}

class Min4 {
    public int minDepth(TreeNode root) {

        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;
        int leftDepth = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
        int rightDepth = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;
        ;

        return Math.min(leftDepth, rightDepth) + 1;
    }
}