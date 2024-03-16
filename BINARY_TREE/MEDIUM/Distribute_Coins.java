package BINARY_TREE.MEDIUM;

//https://leetcode.com/problems/distribute-coins-in-binary-tree/description/
//https://www.youtube.com/watch?v=FmHxY2104hc&list=PLpIkg8OmuX-K23LhcamOcDlTBisiNJy5E&index=36
class Distribute {
    static int moves;

    public int distributeCoins(TreeNode root) {
        moves = 0;
        solve(root);
        return moves;
    }

    public static int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = solve(root.left);
        int right = solve(root.right);
        moves = moves + Math.abs(left) + Math.abs(right);
        int m = (left + right + root.val) - 1;

        return m;
    }
}
