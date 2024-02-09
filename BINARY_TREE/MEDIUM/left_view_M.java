package BINARY_TREE.MEDIUM;

import java.util.ArrayList;
//https://www.codingninjas.com/studio/problems/left-view-of-a-binary-tree_920519

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.data = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }

}

 class Solution {
    public static ArrayList<Integer> getLeftView(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (root == null) {
            return arr;
        } else {

            left(arr, 0, root);
            return arr;

        }
    }

    public static void left(ArrayList<Integer> arr, int level, TreeNode root) {
        if (root == null) {
            return;
        }
        if (arr.size() <= level) {
            arr.add((int) root.data);
        }
        left(arr, level + 1, root.left);
        left(arr, level + 1, root.right);

    }
}
