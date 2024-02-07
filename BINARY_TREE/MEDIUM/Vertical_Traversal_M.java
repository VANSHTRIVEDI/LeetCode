package BINARY_TREE.MEDIUM;

import java.util.*;

//Very Imp Question
//https://www.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1

class Solution {
    // Function to find the vertical order traversal of Binary Tree.
    static ArrayList<Integer> verticalOrder(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (node == null) {
            return ans;
        }

        int col = 0;
        Queue<Map.Entry<Node, Integer>> q = new ArrayDeque<>();
        Map<Integer, ArrayList<Integer>> m = new TreeMap<Integer, ArrayList<Integer>>();

        q.offer(new AbstractMap.SimpleEntry<>(node, col));
        int min = 0;
        int max = 0;
        while (!q.isEmpty()) {
            Map.Entry<Node, Integer> temp = q.remove();
            Node r = temp.getKey();
            col = temp.getValue();

            if (node != null) {

                if (!m.containsKey(col)) {
                    m.put(col, new ArrayList<Integer>());
                }
                m.get(col).add(r.data);

                min = Math.min(min, col);
                max = Math.max(max, col);

                if (r.left != null) {
                    q.offer(new AbstractMap.SimpleEntry<>(r.left, col - 1));
                }
                if (r.right != null) {
                    q.offer(new AbstractMap.SimpleEntry<>(r.right, col + 1));
                }

            }
        }
        // imp
        for (int i = min; i <= max; i++) {
            ans.addAll(m.getOrDefault(i, new ArrayList<>()));

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