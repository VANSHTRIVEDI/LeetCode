package BInary_Search_Tree.MEDIUM;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
import java.util.*;

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

// best way

class kthsamlles {
    public int kthSmallest(TreeNode root, int k) {
        int[] count = { 0 };
        return findKthSmallest(root, k, count);
    }

    public static int findKthSmallest(TreeNode root, int k, int[] count) {

        if (root == null) {
            return -1;
        }

        int left = findKthSmallest(root.left, k, count);

        if (left != -1) {
            return left;
        }

        count[0]++;

        if (count[0] == k) {
            return root.val;
        }

        return findKthSmallest(root.right, k, count);
    }
}

// second way
class kthsamlles2 {
    public static int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        findnode(arr, root);
        if (k > arr.size()) {
            return -1;
        }
        return arr.get(k - 1);

    }

    public static void findnode(ArrayList<Integer> arr, TreeNode root) {
        if (root == null) {
            return;
        }
        findnode(arr, root.left);
        arr.add((int) root.val);
        findnode(arr, root.right);

    }
}
