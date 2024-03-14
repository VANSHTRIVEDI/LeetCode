package BINARY_TREE.MEDIUM;

import java.util.*;

//https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
//DO it after verticalTraversal same concept
// class Node {
//     int data;
//     Node left;
//     Node right;

//     Node(int data) {
//         this.data = data;
//         left = null;
//         right = null;
//     }
// }

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (root == null) {
            return arr;
        } else {
            int col = 0;
            Queue<Map.Entry<Node, Integer>> q = new ArrayDeque<>();
            TreeMap<Integer, Integer> map = new TreeMap<>();
            q.offer(new AbstractMap.SimpleEntry<>(root, col));

            while (!q.isEmpty()) {
                Map.Entry<Node, Integer> removed = q.remove();
                Node temp = removed.getKey();
                col = removed.getValue();

                if (!map.containsKey(col)) {
                    map.put(col, temp.data);
                }
                if (temp.left != null) {
                    q.offer(new AbstractMap.SimpleEntry<>(temp.left, col - 1));
                }
                if (temp.right != null) {
                    q.offer(new AbstractMap.SimpleEntry<>(temp.right, col + 1));
                }

            }
            for (Integer oo : map.values()) {
                arr.add(oo);
            }

            return arr;
        }

    }
}
