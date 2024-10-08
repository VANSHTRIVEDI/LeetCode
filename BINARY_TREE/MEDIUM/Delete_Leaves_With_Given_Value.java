package BINARY_TREE.MEDIUM;

//https://leetcode.com/problems/delete-leaves-with-a-given-value/description/
public class Delete_Leaves_With_Given_Value {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left = removeLeafNodes(root.left, target);
        }
        if (root.right != null) {
            root.right = removeLeafNodes(root.right, target);
        }

        if (root.val == target && root.left == null && root.right == null) {
            return null;
        } else {
            return root;
        }
    }
}
