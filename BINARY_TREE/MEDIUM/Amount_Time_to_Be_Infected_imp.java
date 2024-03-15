package BINARY_TREE.MEDIUM;

//https://www.youtube.com/watch?v=Xm8jIjAK_Zs&list=PLpIkg8OmuX-K23LhcamOcDlTBisiNJy5E&index=36
//this is the dfs method of doing this and its very important 
//https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
class Amount {
    int max;

    public int amountOfTime(TreeNode root, int start) {
        max = 0;
        solve(root, start);
        return max;
    }

    public int solve(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }
        int left = solve(root.left, start);
        int right = solve(root.right, start);

        if (root.val == start) {
            max = Math.max(left, right);
            return -1;
        } else if (left >= 0 && right >= 0) {
            return Math.max(left, right) + 1;
        } else {
            int d = Math.abs(left) + Math.abs(right);
            max = Math.max(max, d);
            return Math.min(left, right) - 1;

        }
    }
}
