package BINARY_TREE.MEDIUM;

import java.util.*;

//bfs method
class Aonerow {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1)
            return new TreeNode(val, root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;

        queue.offer(root);

        while (!queue.isEmpty() && depth > level) {
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                TreeNode curr = queue.poll();

                if (depth - 1 == level) {
                    curr.left = new TreeNode(val, curr.left, null);
                    curr.right = new TreeNode(val, null, curr.right);
                } else {
                    if (curr.left != null)
                        queue.offer(curr.left);

                    if (curr.right != null)
                        queue.offer(curr.right);
                }
            }

            level++;
        }

        return root;
    }
}

// dfs
class Aonerow2 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // Handling the edge case
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        return insertRow(root, val, depth, 1);
    }

    public TreeNode insertRow(TreeNode curNode, int val, int depth, int curDepth) {
        if (curNode == null)
            return null;

        if (depth - 1 == curDepth) {
            TreeNode prevLeft = curNode.left;
            TreeNode prevRight = curNode.right;

            curNode.left = new TreeNode(val, prevLeft, null);
            curNode.right = new TreeNode(val, null, prevRight);
            return curNode;
        }

        curNode.left = insertRow(curNode.left, val, depth, curDepth + 1);
        curNode.right = insertRow(curNode.right, val, depth, curDepth + 1);

        // next one should be inserted

        return curNode;

    }
}
