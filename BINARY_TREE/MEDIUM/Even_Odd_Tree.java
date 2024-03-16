package BINARY_TREE.MEDIUM;

import java.util.*;

//https://leetcode.com/problems/even-odd-tree/
class Oddeven {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (level % 2 == 0) {
                int prev = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode temp = q.poll();
                    if (temp.val % 2 == 1 && temp.val > prev) {
                        prev = temp.val;

                    } else {
                        return false;
                    }
                    if (temp.left != null) {
                        q.offer(temp.left);
                    }
                    if (temp.right != null) {
                        q.offer(temp.right);
                    }
                }

            } else {
                int prev = Integer.MAX_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode temp = q.poll();
                    if (temp.val % 2 == 0 && temp.val < prev) {
                        prev = temp.val;

                    } else {
                        return false;
                    }

                    if (temp.left != null) {
                        q.offer(temp.left);
                    }
                    if (temp.right != null) {
                        q.offer(temp.right);
                    }
                }

            }

            level++;
        }
        return true;
    }
}

// https://www.youtube.com/watch?v=ai7zemxYjz4&list=PLpIkg8OmuX-K23LhcamOcDlTBisiNJy5E&index=42
/***************************************************************
 * JAVA
 *****************************************************************/
// Approach-1 (When we deal with level, always first think of BFS)
// T.C : O(n)
// S.C : O(n)
class Oddeven2 {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean evenLevel = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int prev = evenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            while (size-- > 0) {
                TreeNode node = queue.poll();

                if ((evenLevel && (node.val % 2 == 0 || node.val <= prev)) ||
                        (!evenLevel && (node.val % 2 == 1 || node.val >= prev))) {
                    return false;
                }

                prev = node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            evenLevel = !evenLevel;
        }

        return true;
    }
}

// Approach-2 (DFS)
// T.C : O(n)
// S.C : Auxiliary Space O(n) + Recursion Space O(depth)
class Oddeven3 {
    private List<Integer> levelPrev = new ArrayList<>();

    public boolean isEvenOddTree(TreeNode root) {
        return solve(root, 0);
    }

    private boolean solve(TreeNode root, int level) {
        if (root == null) {
            return true;
        }

        if ((level % 2 == 0 && root.val % 2 == 0) || (level % 2 != 0 && root.val % 2 != 0)) {
            return false;
        }

        if (level >= levelPrev.size()) {
            levelPrev.add(root.val);
        } else {
            if ((level % 2 == 0 && root.val <= levelPrev.get(level)) ||
                    (level % 2 != 0 && root.val >= levelPrev.get(level))) {
                return false;
            }
            levelPrev.set(level, root.val);
        }

        return solve(root.left, level + 1) && solve(root.right, level + 1);
    }
}
