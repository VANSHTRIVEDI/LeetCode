package BINARY_TREE.EASY;
//https://www.geeksforgeeks.org/problems/children-sum-parent/1

class childsum {
    // Function to check whether all nodes of a tree have the value
    // equal to the sum of their child nodes.
    public static int isSumProperty(Node root) {
        if (root == null || root.left == null && root.right == null) {
            return 1;
        }
        int left = isSumProperty(root.left);
        if (left == 0) {
            return 0;
        }

        int right = isSumProperty(root.right);
        if (right == 0) {
            return 0;
        }

        int left1 = root.left == null ? 0 : (int) root.left.data;
        int right1 = root.right == null ? 0 : (int) root.right.data;

        if (left1 + right1 == (int) root.data) {
            return 1;
        }
        return 0;

    }
}
