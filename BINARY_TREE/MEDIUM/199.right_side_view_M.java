package BINARY_TREE.MEDIUM;

//https://leetcode.com/problems/binary-tree-right-side-view/description/

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

// beats 100% of java user dfs using recursion
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (root == null) {
            return arr;
        } else {
            right(arr, root, 0);
            return arr;
        }

    }

    public static void right(ArrayList<Integer> arr, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (arr.size() <= level) {
            arr.add(root.val);
        }
        right(arr, root.right, level + 1);
        right(arr, root.left, level + 1);

    }
}

// just one more way
class Solution3 {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        right(root, map, ans, 0);
        return ans;
    }

    private void right(TreeNode root, Map<Integer, Integer> map, ArrayList<Integer> ans, int i) {
        if (root == null)
            return;
        if (!map.containsKey(i)) {
            map.put(i, root.val);
            ans.add(root.val);
        }
        right(root.right, map, ans, i + 1);
        right(root.left, map, ans, i + 1);
    }
}

// using level order bfs
class Solution2 {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (root == null) {
            return arr;
        } else {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int size = q.size();

                for (int i = 0; i < size; i++) {
                    TreeNode temp = q.remove();
                    if (i == size - 1) {
                        arr.add(temp.val);
                    }
                    if (temp.left != null) {
                        q.offer(temp.left);
                    }
                    if (temp.right != null) {
                        q.offer(temp.right);
                    }

                }

            }
            return arr;
        }
    }
}