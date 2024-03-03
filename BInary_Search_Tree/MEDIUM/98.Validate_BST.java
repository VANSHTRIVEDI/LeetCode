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

// better way
class Validatee2 {
    public boolean isValidBST(TreeNode root) {
        // we are using long.minvalue beacuse of the data limit
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public static boolean validate(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        // if((int)root.data>=min && (int)root.data<=max) if nodeleft can be equal to
        // node
        if (root.val > min && root.val < max) {
            Boolean left = validate(root.left, min, root.val);
            Boolean right = validate(root.right, root.val, max);

            return left && right;
        }
        return false;

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