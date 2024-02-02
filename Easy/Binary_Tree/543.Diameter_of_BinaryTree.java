package Easy.Binary_Tree;

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

// firstWay But timecomplexity is o(n*2)
class Solution {
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        int ans = maax(left, right) + 1;
        return ans;
    }

    public static int maax(int num1, int num2) {
        return Math.max(num1, num2);
    }

    public static int findMax(int num1, int num2, int num3) {
        int max = num1;

        if (num2 > max) {
            max = num2;
        }

        if (num3 > max) {
            max = num3;
        }

        return max;
    }

    public int diameterOfBinaryTree(TreeNode root) {

        int p = diameter(root);
        return p - 1;

    }

    public int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int opt1 = diameter(root.left);
        int opt2 = diameter(root.right);
        int opt3 = height(root.left) + height(root.right) + 1;

        int ans = findMax(opt1, opt2, opt3);
        return ans;

    }

}
