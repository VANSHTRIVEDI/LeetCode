package BINARY_TREE.MEDIUM;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/
class max {
    public int maxPathSum(TreeNode root) {
        int arr[] = new int[1];
        arr[0] = Integer.MIN_VALUE;
        solve(root, arr);
        return arr[0];

    }

    public static int solve(TreeNode root, int arr[]) {
        if (root == null) {
            return 0;
        }
        int leftsum = Math.max(0, solve(root.left, arr));
        int rightsum = Math.max(0, solve(root.right, arr));
        arr[0] = Math.max(arr[0], leftsum + rightsum + root.val);

        return Math.max(leftsum, rightsum) + root.val;

    }

}
