package BINARY_TREE.MEDIUM;

import java.util.*;

//important method using dfs and arraylist
class Largest {
    public static void calc(TreeNode root, List<Integer> list, int height) {
        if (root == null)
            return;
        int curr = root.val;
        if (list.size() == height)
            list.add(curr);
        else {
            if (curr > list.get(height)) {
                list.set(height, curr);
            }
        }
        calc(root.right, list, height + 1);
        calc(root.left, list, height + 1);
        return;
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        calc(root, list, 0);
        return list;
    }
}

// using bfs
class Solution {
    ArrayList<Integer> maximumValue(Node node) {
        ArrayList<Integer> maxValues = new ArrayList<>();
        if (node == null)
            return maxValues;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int max = Integer.MIN_VALUE;

            // Iterate through the nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                max = Math.max(max, current.data);

                // Add children to the queue
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }

            // Add the maximum value of the current level to the list
            maxValues.add(max);
        }

        return maxValues;
    }
}