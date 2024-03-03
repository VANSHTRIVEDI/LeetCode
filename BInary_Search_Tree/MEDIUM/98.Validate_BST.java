package BInary_Search_Tree.MEDIUM;

import java.util.*;
//https://leetcode.com/problems/validate-binary-search-tree/

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

class Validatee {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        if (checksorted(arr)) {
            return true;
        } else {
            return false;
        }
    }

    public static void inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }

    public static boolean checksorted(ArrayList<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i - 1) < arr.get(i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}