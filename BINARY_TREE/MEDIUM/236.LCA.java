package BINARY_TREE.MEDIUM;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode arr[] = new TreeNode[1];
        if (root == null || root == p || root == q) {
            return root;
        }
        rec(root, p, q, arr);
        return arr[0];

    }

    public static boolean rec(TreeNode root, TreeNode p, TreeNode q, TreeNode arr[]) {
        if (root == null) {
            return false;
        }
        boolean left = rec(root.left, p, q, arr);
        boolean right = rec(root.right, p, q, arr);
        if (arr[0] == null) {
            if (left == true && right == true) {
                arr[0] = root;
            }
            if ((left == true || right == true) && (root == p || root == q)) {
                arr[0] = root;
            }

        }
        if (root == p || root == q || left == true || right == true) {
            return true;
        }
        return false;

    }
}
