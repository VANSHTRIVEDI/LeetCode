package BINARY_TREE.EASY;

import java.util.*;;

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

// dfs
class Symmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return solve(root.left, root.right);
    }

    public static boolean solve(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        boolean check1 = solve(left.left, right.right);
        if (check1 == false) {
            return false;
        }
        boolean check2 = solve(left.right, right.left);

        return (left.val == right.val) && check1 && check2;
    }
}

// bfs
class Symmetric2 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return true;
        }
        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty()) {

            TreeNode first = q.remove();
            TreeNode second = q.remove();

            if (first == null && second == null) {
                continue;
            }

            // if not submit in coding ninjas it because of compiler use equals as just
            // (!first.val.equals(second.val))
            // intead of ( first.val!=second.val )
            if ((first == null || second == null) || (first.val != second.val)) {
                return false;
            }

            q.add(first.left);
            q.add(second.right);
            q.add(first.right);
            q.add(second.left);

        }
        return true;

    }
}