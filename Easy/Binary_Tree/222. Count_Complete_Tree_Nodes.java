package Easy.Binary_Tree;

//   Definition for a binary tree node.
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

class Solution {
    public static void lrc(TreeNode root, int arr[]) {
        if (root == null) {
            return;
        }
        arr[0] = arr[0] + 1;
        lrc(root.left, arr);
        lrc(root.right, arr);
    }

    public int countNodes(TreeNode root) {
        int arr[] = new int[1];
        lrc(root, arr);
        return arr[0];
    }
}
