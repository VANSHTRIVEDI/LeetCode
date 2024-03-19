package BINARY_TREE.HARD;

import java.util.*;

//https://leetcode.com/problems/merge-bsts-to-create-single-bst/description/
class Solution {
    public TreeNode canMerge(List<TreeNode> trees) {
        HashMap<Integer, TreeNode> map = new HashMap<>();

        for (int i = 0; i < trees.size(); i++) {
            if (map.containsKey(trees.get(i).val)) {
                return null;
            }
            map.put(trees.get(i).val, trees.get(i));
        }
        TreeNode root = trees.get(0);
        // System.out.println(map);

        for (int i = 0; i < trees.size(); i++) {
            if (map.containsKey(trees.get(i).val) && dfs(trees.get(i), map)) {
                root = trees.get(i);
                map.put(trees.get(i).val, root);
            }
        }

        if (map.size() == 1 && root != null) {
            return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE) == true ? root : null;
        }

        return null;
    }

    public boolean dfs(TreeNode node, HashMap<Integer, TreeNode> map) {
        // boolean flag=false;
        boolean left = false;
        boolean right = false;
        if (node.left != null && map.containsKey(node.left.val)) {
            node.left = map.get(node.left.val);
            map.remove(node.left.val);

            left = left || dfs(node.left, map);
            left = left || true;

            // flag |= dfs(node.left, map);
            // flag |= true;

        }

        if (node.right != null && map.containsKey(node.right.val)) {

            node.right = map.get(node.right.val);
            map.remove(node.right.val);

            right = right || dfs(node.right, map);
            right = right || true;

            // flag |= dfs(node.right, map);
            // flag |= true;

        }

        return left || right;
        // return flag
    }

    public boolean check(TreeNode root, int leftMin, int rightMin) {
        if (root == null) {
            return true;
        }

        if (root.val <= leftMin || root.val >= rightMin) {
            return false;
        }

        return check(root.left, leftMin, root.val) & check(root.right, root.val, rightMin);
    }

}
