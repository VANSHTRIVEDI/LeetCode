package BINARY_TREE.MEDIUM;

import java.util.*;

//https://leetcode.com/problems/path-sum-iii/description/?source=submission-ac

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

class Path {
    public int pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> auu = new ArrayList<Integer>();
        int arr[] = new int[1];
        rec(root, targetSum, arr, auu);
        return arr[0];
    }

    public static void rec(TreeNode root, int targetSum, int arr[], ArrayList<Integer> auu) {
        if (root == null) {
            return;
        }
        auu.add(root.val);
        rec(root.left, targetSum, arr, auu);
        rec(root.right, targetSum, arr, auu);

        long sum = 0;
        for (int i = auu.size() - 1; i >= 0; i--) {
            sum = sum + auu.get(i);
            if (sum == targetSum) {
                arr[0] = arr[0] + 1;
            }
        }
        auu.remove(auu.size() - 1);

    }
}
