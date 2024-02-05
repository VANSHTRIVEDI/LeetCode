package BINARY_TREE.EASY;

//https://leetcode.com/problems/balanced-binary-tree/description/

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

// this is the better way cause its now using array and if left is -1 then we
// are not calculating for right
class Solution2 {
    public boolean isBalanced(TreeNode root) {
        // If the tree is empty, we can say it’s balanced...
        if (root == null)
            return true;
        // Height Function will return -1, when it’s an unbalanced tree...
        if (Height(root) == -1)
            return false;
        return true;
    }

    // Create a function to return the “height” of a current subtree using
    // recursion...
    public int Height(TreeNode root) {
        // Base case...
        if (root == null)
            return 0;
        // Height of left subtree...
        int leftHeight = Height(root.left);

        // if we find that leftHeight is already -1 we dont have to calculate for right
        // cause its
        // already false it doesnt matter if right is true or not
        if (leftHeight == -1) {
            return -1;
        }
        // Height of height subtree...
        int rightHight = Height(root.right);
        // In case of left subtree or right subtree unbalanced, return -1...
        if (leftHeight == -1 || rightHight == -1)
            return -1;
        // If their heights differ by more than ‘1’, return -1...
        if (Math.abs(leftHeight - rightHight) > 1)
            return -1;
        // Otherwise, return the height of this subtree as max(leftHeight, rightHight) +
        // 1...
        return Math.max(leftHeight, rightHight) + 1;
    }
}

// first way using array
class Solution {
    public boolean isBalanced(TreeNode root) {
        int arr[] = new int[1];
        Balanced(root, arr);
        if (arr[0] == -1) {
            return false;
        } else {
            return true;
        }
    }

    public int Balanced(TreeNode root, int arr[]) {
        if (root == null) {
            return 0;
        }
        int left = Balanced(root.left, arr);
        int right = Balanced(root.right, arr);
        if (Math.abs(left - right) > 1) {
            arr[0] = -1;
        }
        return Math.max(left, right) + 1;
    }

}