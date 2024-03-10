package BInary_Search_Tree.MEDIUM;
//https://www.codingninjas.com/studio/problems/largest-bst-subtree_893103?leftPanelTab=0&leftPanelTabValue=PROBLEM

//https://www.geeksforgeeks.org/problems/largest-bst/1
//important question

class Solution {

    public static int largestBST(TreeNode root) {
        int maxans[] = new int[1];
        solve(root, maxans);
        return maxans[0];

    }

    public static info solve(TreeNode root, int maxans[]) {
        if (root == null) {
            return new info(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        info left = solve(root.left, maxans);
        info right = solve(root.right, maxans);

        info curNode = new info(false, Integer.MIN_VALUE, Integer.MAX_VALUE, 0); // Initialize curNode
        curNode.size = left.size + right.size + 1;
        curNode.min = Math.min((int) root.data, left.min);
        curNode.max = Math.max((int) root.data, right.max);

        if (left.isbst && right.isbst && (int) root.data > left.max && (int) root.data < right.min) {
            curNode.isbst = true;
        } else {
            curNode.isbst = false;
        }
        if (curNode.isbst) {
            maxans[0] = Math.max(maxans[0], curNode.size);
        }
        return curNode;
    }
}

class info {
    boolean isbst;
    int max;
    int min;
    int size;

    info(boolean isbst, int max, int min, int size) {
        this.isbst = isbst;
        this.max = max;
        this.min = min;
        this.size = size;
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
};
