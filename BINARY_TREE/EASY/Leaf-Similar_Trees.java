package BINARY_TREE.EASY;
//https://leetcode.com/problems/leaf-similar-trees/

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        inorder(root1, true, s1);
        inorder(root2, false, s2);
        return s1.toString().equals(s2.toString());
    }

    public void inorder(TreeNode root, boolean root1, StringBuilder sb) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sb.append(root.val).append(" ");
        }
        inorder(root.left, root1, sb);
        inorder(root.right, root1, sb);
    }
}
