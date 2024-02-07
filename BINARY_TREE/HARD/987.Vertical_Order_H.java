package BINARY_TREE.HARD;

import java.util.*;

//Very Important Question

//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
//This is a different vertical traversal which also sorts the collapsing col
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
    public List<List<Integer>> verticalTraversal(TreeNode node) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (node == null) {
            return ans;
        }
        int col = 0;
        int row = 0;
        Queue<T> q = new LinkedList<T>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        q.offer(new T(node, 0, 0));
        while (!q.isEmpty()) {
            T temp = q.remove();
            TreeNode removed = temp.val;
            col = temp.col;
            row = temp.row;

            if (!map.containsKey(col)) {
                map.put(col, new TreeMap<>());
            }
            if (!map.get(col).containsKey(row)) {
                map.get(col).put(row, new PriorityQueue<>());
            }
            map.get(col).get(row).offer(removed.val);

            if (removed.left != null) {
                q.offer(new T(removed.left, col - 1, row + 1));
            }
            if (removed.right != null) {
                q.offer(new T(removed.right, col + 1, row + 1));
            }

        }
        for (TreeMap<Integer, PriorityQueue<Integer>> jj : map.values()) {
            ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> p : jj.values()) {
                while (!p.isEmpty()) {
                    ans.get(ans.size() - 1).add(p.poll());
                }

            }

        }

        return ans;
    }
}

class T {
    TreeNode val;
    int col;
    int row;

    T(TreeNode vall, int coll, int roww) {
        this.val = vall;
        this.col = coll;
        this.row = roww;

    }
}

// Second way to solve without making a new class using Map.Entry
// and AbstractMap.SimpleEntry<>

class Solution2 {
    public List<List<Integer>> verticalTraversal(TreeNode node) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        if (node == null) {
            return ans;
        }

        int col = 0;
        int row = 0;
        Queue<Map.Entry<TreeNode, Map.Entry<Integer, Integer>>> q = new ArrayDeque<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        q.offer(new AbstractMap.SimpleEntry<>(node, new AbstractMap.SimpleEntry<>(col, row)));
        while (!q.isEmpty()) {
            Map.Entry<TreeNode, Map.Entry<Integer, Integer>> temp = q.remove();

            TreeNode removed = temp.getKey();
            Map.Entry<Integer, Integer> temp2 = temp.getValue();
            col = temp2.getKey();
            row = temp2.getValue();

            if (!map.containsKey(col)) {
                map.put(col, new TreeMap<>());
            }
            if (!map.get(col).containsKey(row)) {
                map.get(col).put(row, new PriorityQueue<>());
            }
            map.get(col).get(row).offer(removed.val);

            if (removed.left != null) {

                q.offer(new AbstractMap.SimpleEntry<>(removed.left, new AbstractMap.SimpleEntry<>(col - 1, row + 1)));
            }
            if (removed.right != null) {
                q.offer(new AbstractMap.SimpleEntry<>(removed.right, new AbstractMap.SimpleEntry<>(col + 1, row + 1)));
            }

        }
        for (TreeMap<Integer, PriorityQueue<Integer>> jj : map.values()) {
            ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> p : jj.values()) {
                while (!p.isEmpty()) {
                    ans.get(ans.size() - 1).add(p.poll());
                }

            }

        }

        return ans;
    }
}

// These are some loops for map

// List<Integer> mergedList = new ArrayList<>();
// for (List<Integer> list : sortedMap.values()) {
// mergedList.addAll(list);
// }

// for (Map.Entry<Integer, List<Integer>> entry : sortedMap.entrySet()) {
// // Sort the list value
// List<Integer> sortedList = new ArrayList<>(entry.getValue());
// Collections.sort(sortedList);

// // Add the sorted list to the list of lists
// listOfLists.add(sortedList);
// }
