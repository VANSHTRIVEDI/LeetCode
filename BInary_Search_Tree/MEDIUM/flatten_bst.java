package BInary_Search_Tree.MEDIUM;

import java.util.*;
//https://www.codingninjas.com/studio/problems/flatten-bst-to-a-sorted-list_1169459?leftPanelTab=0&leftPanelTabValue=PROBLEM

class TreeNode<T> {
    public T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

// my way
class flattenbst {
    static TreeNode head = null;

    public static TreeNode<Integer> flatten(TreeNode<Integer> root) {
        // Write your code here
        TreeNode arr[] = { null };
        findHead(root, arr);
        solve(root);
        return arr[0];
    }

    public static void findHead(TreeNode root, TreeNode[] arr) {
        while (root.left != null) {
            root = root.left;
        }

        arr[0] = root;
        head = root;
    }

    public static void solve(TreeNode root) {
        if (root == null) {
            return;
        }
        solve(root.left);

        if (head != root) {
            head.right = root;
            root.left = null;
            head = root;
        }
        solve(root.right);
    }
}

// love babbar way using arrayList and inorder traversal
class flattenbst2 {
    public static TreeNode<Integer> flatten(TreeNode<Integer> root) {
        // Write your code here
        ArrayList<TreeNode<Integer>> nodeList = new ArrayList<>();
        findHead(root, nodeList);

        for (int i = 1; i < nodeList.size(); i++) {
            TreeNode<Integer> temp = nodeList.get(i - 1);
            temp.right = nodeList.get(i);
            temp.left = null;
            if (i == nodeList.size() - 1) {
                TreeNode<Integer> ff = nodeList.get(i);
                ff.left = null;
                ff.right = null;
            }
        }

        return nodeList.get(0);
    }

    public static void findHead(TreeNode<Integer> root, ArrayList<TreeNode<Integer>> nodeList) {
        if (root == null) {
            return;
        }
        findHead(root.left, nodeList);
        nodeList.add(root);
        findHead(root.right, nodeList);
    }
}
