package BINARY_TREE.MEDIUM;

//https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/

//this is exactly same to time to burn tree

//it beates 70% of java users
import java.util.*;

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

class Solution {
    public int amountOfTime(TreeNode root, int target) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode node = find(root, target, map);

        if (node == null) {
            return 0;
        }
        int t = solve(node, map);
        return t;
    }

    // this is the best method we can also use dfs here but this is better
    public static TreeNode find(TreeNode root, int target, HashMap<TreeNode, TreeNode> map) {
        TreeNode ans = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if ((int) temp.val == target) {
                ans = temp;
            }
            if (temp.left != null) {
                map.put(temp.left, temp);
                q.add(temp.left);
            }
            if (temp.right != null) {
                map.put(temp.right, temp);
                q.add(temp.right);
            }

        }
        return ans;

    }

    public static int solve(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(root, true);

        Queue<TreeNode> traversal = new LinkedList<>();

        traversal.offer(root);
        int count = 0;
        while (!traversal.isEmpty()) {
            int size = traversal.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = traversal.poll();

                if (temp.left != null && visited.containsKey(temp.left) == false) {
                    traversal.offer(temp.left);
                    visited.put(temp.left, true);

                }
                if (temp.right != null && visited.containsKey(temp.right) == false) {
                    traversal.offer(temp.right);
                    visited.put(temp.right, true);

                }
                if (map.get(temp) != null && visited.containsKey(map.get(temp)) == false) {
                    traversal.offer(map.get(temp));
                    visited.put(map.get(temp), true);

                }

            }

            count++;

        }

        return count - 1;
    }
}
