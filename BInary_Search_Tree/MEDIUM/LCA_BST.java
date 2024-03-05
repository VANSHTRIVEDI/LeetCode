package BInary_Search_Tree.MEDIUM;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
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

class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;

    }
}

// same logic but without using recursion to free stack memory
class BST {
    // Function to find the lowest common ancestor in a BST.
    Node LCA(Node root, int p, int q) {
        Node temp = null;
        while (root != null) {
            if (((int) root.data > p) && ((int) root.data > q)) {
                root = root.left;
            } else if (((int) root.data < p) && ((int) root.data < q)) {
                root = root.right;
            } else {
                return root;

            }

        }

        return null;
    }

}
