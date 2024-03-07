package BInary_Search_Tree.MEDIUM;

import java.util.*;

//https://leetcode.com/problems/balance-a-binary-search-tree/
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

class balance {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        fillarr(arr, root);

        TreeNode ans = makeTree(arr, 0, arr.size() - 1);
        return ans;
    }

    public static void fillarr(ArrayList<Integer> arr, TreeNode root) {
        if (root == null) {
            return;
        }
        fillarr(arr, root.left);
        arr.add((int) root.val);
        fillarr(arr, root.right);
    }

    public static TreeNode makeTree(ArrayList<Integer> arr, int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = s + (e - s) / 2;
        TreeNode newnode = new TreeNode(arr.get(mid));
        newnode.left = makeTree(arr, s, mid - 1);
        newnode.right = makeTree(arr, mid + 1, e);

        return newnode;
    }
}
