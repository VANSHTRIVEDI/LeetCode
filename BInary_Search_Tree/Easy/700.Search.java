package BInary_Search_Tree.Easy;

//https://leetcode.com/problems/search-in-a-binary-search-tree/

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

class search {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode left = null;
        if (root.val > val) {
            left = searchBST(root.left, val);
        } else {
            left = searchBST(root.right, val);
        }
        return left;
    }
}
