package BINARY_TREE.MEDIUM;

//https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
class Solution {
    static int max;

    public int averageOfSubtree(TreeNode root) {
        max = 0;
        solve(root);
        return max;
    }

    public static Pair solve(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair left = solve(root.left);
        Pair right = solve(root.right);

        int count = left.count + right.count + 1;
        int sum = left.sum + right.sum + (int) root.val;
        int avgval = (sum / count);
        if (root.val == avgval) {
            max++;
        }

        return new Pair(sum, count);
    }

}

class Pair {
    int sum;
    int count;

    Pair(int avg, int c) {
        this.sum = avg;
        this.count = c;
    }
}
