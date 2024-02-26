package BINARY_TREE.MEDIUM;
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

//we are using morris traversal o(n)time and o(1) space
class Flatten {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {

            if (cur.left != null) {

                TreeNode prev = cur.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }

            cur = cur.right;

        }
    }
}

// using recursion o(n)time and o(n) space
class Flatten2 {
    TreeNode head = null;

    public void flatten(TreeNode root) {
        if (root != null)
            revPreOrder(root);
    }

    private void revPreOrder(TreeNode node) {
        if (node.right != null)
            revPreOrder(node.right);
        if (node.left != null)
            revPreOrder(node.left);
        node.left = null;
        node.right = head;
        head = node;
    }
}