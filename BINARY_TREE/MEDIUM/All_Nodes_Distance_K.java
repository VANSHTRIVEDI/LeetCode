package BINARY_TREE.MEDIUM;

import java.util.*;
//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

//my solution using bfs and dfs
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class AllNodesDistance {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> arr = new ArrayList<>();
        if (root == null) {
            return null;
        }
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode kk = parentandm(map, root, target);
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        while (kk != null) {
            solve(kk, k, arr, 0, visited);
            visited.put(kk, true);
            k--;
            kk = map.get(kk);

        }
        return arr;

    }

    public static TreeNode parentandm(HashMap<TreeNode, TreeNode> map, TreeNode root, TreeNode target) {
        TreeNode pp = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        map.put(root, null);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();

            if (temp == target) { // we dont need this cause target is already given in treenode type
                pp = temp;
            }
            if (temp.left != null) {
                map.put(temp.left, temp);
                q.offer(temp.left);
            }

            if (temp.right != null) {
                map.put(temp.right, temp);
                q.offer(temp.right);
            }

        }
        return pp;
    }

    public static void solve(TreeNode root, int k, List<Integer> arr, int pp, HashMap<TreeNode, Boolean> visited) {
        if (root == null) {
            return;
        }
        if (k == pp) {
            arr.add((int) root.val);
            return;
        }
        if (visited.containsKey(root.left) == false)
            solve(root.left, k, arr, pp + 1, visited);

        if (visited.containsKey(root.right) == false)
            solve(root.right, k, arr, pp + 1, visited);
    }

}

// using bfs striver's solution
// https://www.youtube.com/watch?v=i9ORlEy6EsI&t=3s
class AllNodesDistance2 {
    void markParents(TreeNode root, HashMap<TreeNode, TreeNode> parentTrack) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left != null) {
                parentTrack.put(current.left, current);
                queue.offer(current.left);
            }

            if (current.right != null) {
                parentTrack.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentTrack = new HashMap<>();
        markParents(root, parentTrack);

        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);

        int level = 0;
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (level == k) {
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.left != null && !visited.contains(current.left)) {
                    queue.offer(current.left);
                    visited.add(current.left);
                }

                if (current.right != null && !visited.contains(current.right)) {
                    queue.offer(current.right);
                    visited.add(current.right);
                }

                TreeNode parent = parentTrack.get(current);
                if (parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
            level++;
        }

        return result;
    }
}
