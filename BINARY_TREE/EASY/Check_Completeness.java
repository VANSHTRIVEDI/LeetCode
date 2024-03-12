package BINARY_TREE.EASY;

import java.util.*;

//https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/
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

class Check {
    static int number = 0;

    public boolean isCompleteTree(TreeNode root) {
        number = 0;
        findnumberofnodes(root);
        return solve(root, 1);
    }

    public static void findnumberofnodes(TreeNode root) {
        if (root == null) {
            return;
        }
        findnumberofnodes(root.left);
        number++;
        findnumberofnodes(root.right);

    }

    public static boolean solve(TreeNode root, int c) {
        if (root == null) {
            return true;
        }
        if (c > number) {
            return false;
        }
        boolean left = solve(root.left, 2 * c);

        if (left == false) {
            return false;
        }

        boolean right = solve(root.right, (2 * c) + 1);

        return left && right;
    }
}

class Check2 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean past = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (temp == null) {
                    past = true;

                } else {
                    if (past) {
                        return false;
                    }
                    q.offer(temp.left);
                    q.offer(temp.right);

                }

            }
        }
        return true;
    }
}
