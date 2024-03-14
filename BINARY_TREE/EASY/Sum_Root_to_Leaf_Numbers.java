package BINARY_TREE.EASY;

//https://leetcode.com/problems/sum-root-to-leaf-numbers/
class sum2 {
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }

    private int sumNumbersHelper(TreeNode root, int currentSum) {
        if (root == null) {
            return 0;
        }

        // Update the current sum
        int newSum = currentSum * 10 + root.val;

        // If it's a leaf node, return the sum
        if (root.left == null && root.right == null) {
            return newSum;
        }

        // Recursively calculate sum for left and right subtrees
        int leftSum = sumNumbersHelper(root.left, newSum);
        int rightSum = sumNumbersHelper(root.right, newSum);

        // Return the sum of both subtrees
        return leftSum + rightSum;
    }
}

// this is for when the sum can be very large
class sum {
    public static int rootToLeafSum(BinaryTreeNode<Integer> root) {
        long sum = sumNumbersHelper(root, 0L) % 1000000007;
        return (int) sum;
    }

    public static long sumNumbersHelper(BinaryTreeNode<Integer> root, long currentSum) {
        if (root == null) {
            return 0;
        }

        // Update the current sum
        long newSum = (currentSum * 10 + root.data) % 1000000007;

        // If it's a leaf node, return the sum
        if (root.left == null && root.right == null) {
            return newSum;
        }

        // Recursively calculate sum for left and right subtrees
        long leftSum = sumNumbersHelper(root.left, newSum);
        long rightSum = sumNumbersHelper(root.right, newSum);

        // Return the sum of both subtrees
        return (leftSum + rightSum) % 1000000007;
    }
}
