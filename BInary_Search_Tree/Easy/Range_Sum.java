package BInary_Search_Tree.Easy;

//https://leetcode.com/problems/range-sum-of-bst/
class Range {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val >= low && root.val <= high) {
            // return 1+getCount(root.left,low,high)+getCount(root.right,low,high);
            // this is for the question if someone ask number of nodes lie between the range
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        return rangeSumBST(root.left, low, high);

    }
}

// class TreeNode {
// int val;
// TreeNode left;
// TreeNode right;

// TreeNode() {
// }

// TreeNode(int val) {
// this.val = val;
// }

// TreeNode(int val, TreeNode left, TreeNode right) {
// this.val = val;
// this.left = left;
// this.right = right;
// }
// }
