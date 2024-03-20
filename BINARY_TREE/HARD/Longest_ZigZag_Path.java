package BINARY_TREE.HARD;

//https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/
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

class ZigZag {
    static int max;

    public int longestZigZag(TreeNode root) {
        max = 0;
        solve(root, 0, 0);
        return max;
    }

    public static void solve(TreeNode root, int left, int right) {

        if (root == null) {
            return;
        }

        max = Math.max(max, Math.max(left, right));
        solve(root.left, right + 1, 0);
        solve(root.right, 0, left + 1);

    }

}

class ZigZag2 {
    static int max;

    public int longestZigZag(TreeNode root) {
        max = 0;
        solve(root, 0, true);
        return max;
    }

    public static void solve(TreeNode root, int count, boolean lefttrue) {
        if (root == null) {
            return;
        }
        max = max < count ? count : max;

        if (lefttrue == true) {
            solve(root.left, count + 1, false);
            solve(root.right, 1, true);
        } else {
            solve(root.right, count + 1, true);
            solve(root.left, 1, false);
        }

    }

}
