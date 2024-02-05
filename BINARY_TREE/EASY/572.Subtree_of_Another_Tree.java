package BINARY_TREE.EASY;

//https://leetcode.com/problems/subtree-of-another-tree/

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

// this is the first way beating 99% of java user
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null)
            return false;

        boolean left = isSubtree(root.left, subRoot);
        if (left == true) {
            return true;
        }
        boolean right = isSubtree(root.right, subRoot);
        if (right == true) {
            return true;
        }

        if (isidentical(root, subRoot) == true) {
            return true;
        } else {
            return false;
        }
    }

    // this is also a way to do the program beating 96% of java user
    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;
        if (isidentical(root, subRoot))
            return true;
        return isSubtree2(root.left, subRoot) || isSubtree2(root.right, subRoot);

    }

    public boolean isidentical(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean left = isidentical(p.left, q.left);
        if (left == false) {
            return false;
        }
        boolean right = isidentical(p.right, q.right);
        if (right == false) {
            return false;
        }
        return true;

    }

}
