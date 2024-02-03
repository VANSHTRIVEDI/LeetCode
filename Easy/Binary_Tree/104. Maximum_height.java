package Easy.Binary_Tree;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

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

// Second Way
class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int ans = max(left, right) + 1;
        return ans;

    }

    public int max(int left, int right) {
        if (left < right) {
            return right;
        } else {
            return left;
        }

    }

}

// First Way
class Solution {
    public int maxDepth(TreeNode root) {
        int arr[] = new int[1];
        depth(root, arr, 0);
        return arr[0];
    }

    public void depth(TreeNode root, int arr[], int k) {
        if (root == null) {
            if (arr[0] < k) {
                arr[0] = k;

            }
            return;
        }
        depth(root.left, arr, k = k + 1);
        k--;
        depth(root.right, arr, k = k + 1);

    }
}
