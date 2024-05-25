package BINARY_TREE.HARD;

//https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode() {
//     }

//     TreeNode(int val) {
//         this.val = val;
//     }

//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
    static int maxx;

    public int maxSumBST(TreeNode root) {
        maxx = 0;
        solve(root);
        return maxx;
    }

    public static info solve(TreeNode root) {
        if (root == null) {
            return new info(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        info left = solve(root.left);
        info right = solve(root.right);

        info currenode = new info(false, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        currenode.sum = left.sum + right.sum + root.val;
        currenode.min = Math.min(root.val, left.min);
        currenode.max = Math.max(root.val, right.max);

        if (left.bst == true && right.bst == true && root.val > left.max && root.val < right.min) {
            currenode.bst = true;
        } else {
            currenode.bst = false;
            ;
        }

        if (currenode.bst == true) {
            maxx = Math.max(maxx, currenode.sum);
        }

        return currenode;
    }
}

class info {
    int max;
    int min;
    boolean bst;
    int sum;

    info(boolean b, int mx, int mn, int s) {
        this.bst = b;
        this.min = mn;
        this.max = mx;
        this.sum = s;
    }
}
