package BInary_Search_Tree.MEDIUM;

import java.util.*;

//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
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

// easy appoach using max and min
class bst {
    public TreeNode bstFromPreorder(int[] preorder) {
        int arr[] = new int[1];
        return solve(preorder, arr, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public static TreeNode solve(int[] preorder, int arr[], int min, int max) {
        if (arr[0] >= preorder.length)
            return null;

        if (preorder[arr[0]] < min || preorder[arr[0]] > max) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[arr[0]]);
        arr[0] = arr[0] + 1;

        root.left = solve(preorder, arr, min, (int) root.val);
        root.right = solve(preorder, arr, (int) root.val, max);

        return root;
    }
}

// optimise apporach only using max value
class bst2 {
    public static TreeNode preOrderTree(int[] preorder) {

        int arr[] = new int[1];
        return solve(preorder, arr, Integer.MAX_VALUE);
    }

    public static TreeNode solve(int[] preorder, int arr[], int max) {
        if (arr[0] >= preorder.length || preorder[arr[0]] > max)
            return null;

        TreeNode root = new TreeNode(preorder[arr[0]]);
        arr[0] = arr[0] + 1;

        root.left = solve(preorder, arr, (int) root.val);
        root.right = solve(preorder, arr, max);

        return root;
    }

}

// coding ninjas was showing stackover due to large subset
// so using while to pass it
// withour recursion
class bst3 {
    public static TreeNode preOrderTree(int[] preorder) {
        if (preorder == null || preorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode temp = null;

            while (!stack.isEmpty() && preorder[i] > stack.peek().val) {
                temp = stack.pop();
            }

            if (temp != null) {
                temp.right = new TreeNode(preorder[i]);
                stack.push(temp.right);
            } else {
                temp = stack.peek();
                temp.left = new TreeNode(preorder[i]);
                stack.push(temp.left);
            }
        }

        return root;
    }

}
