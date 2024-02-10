package BINARY_TREE.MEDIUM;

import java.util.*;
//https://www.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1

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

class Tree {
    public ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        LinkedHashMap<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();
        rec(map, root, 0);
        for (ArrayList<Integer> jj : map.values()) {
            for (Integer p : jj) {
                ans.add(p);
            }
        }
        return ans;
    }

    // using dfs
    public static void rec(LinkedHashMap<Integer, ArrayList<Integer>> map, Node node, int col) {
        if (node == null) {
            return;
        }
        if (!map.containsKey(col)) {
            map.put(col, new ArrayList<>());

        }
        map.get(col).add(node.data);

        // If we want to use Tree Map this way wee can to it
        // diagonalPrintUtil(map, node.left,col+ 1);

        rec(map, node.left, col - 1);
        rec(map, node.right, col);

    }

    // This is using bfs
    public static List<Integer> diagonalq(Node root) {
        List<Integer> diagonalVals = new ArrayList<>();
        if (root == null)
            return diagonalVals;

        // The leftQueue will be a queue which will store
        // all left pointers while traversing the tree, and
        // will be utilized when at any point right pointer
        // becomes NULL

        Queue<Node> leftQueue = new LinkedList<>();
        Node node = root;

        while (node != null) {

            diagonalVals.add(node.data);

            if (node.left != null)
                leftQueue.add(node.left);

            if (node.right != null)
                node = node.right;
            else {

                if (!leftQueue.isEmpty()) {
                    node = leftQueue.peek();
                    leftQueue.remove();
                } else {

                    node = null;
                }
            }
        }
        return diagonalVals;
    }

}
