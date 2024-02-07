package BINARY_TREE.MEDIUM;

import java.util.*;

//https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
//DO it after verticalTraversal same concept

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (root == null) {
            return arr;
        } else {
            int col = 0;
            Queue<T> q = new LinkedList<>();
            TreeMap<Integer, Integer> map = new TreeMap<>();
            q.offer(new T(root, col));
            while (!q.isEmpty()) {
                T removed = q.remove();
                Node temp = removed.temp;
                col = removed.col;

                if (!map.containsKey(col)) {
                    map.put(col, 0);
                }
                map.put(col, temp.data);

                if (temp.left != null) {
                    q.offer(new T(temp.left, col - 1));
                }
                if (temp.right != null) {
                    q.offer(new T(temp.right, col + 1));
                }

            }
            for (Integer pp : map.values()) {
                arr.add(pp);
            }

        }
        return arr;

    }
}

class T {
    Node temp;
    int col;

    T(Node temp, int col) {
        this.temp = temp;
        this.col = col;
    }
}
