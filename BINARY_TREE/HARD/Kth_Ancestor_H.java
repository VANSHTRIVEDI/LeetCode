package BINARY_TREE.HARD;

import java.util.*;;
//https://www.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1

//This is the second method of the same program which we have already did in medium 

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}

class k {
    public int kthAncestor(Node root, int k, int node) {
        int arr[] = new int[1];
        arr[0] = k;
        Node temp = solve(root, node, arr);
        // System.out.println("array"arr);
        if (temp == null || temp.data == node) {
            return -1;
        } else {
            return temp.data;
        }

    }

    public static Node solve(Node root, int node, int arr[]) {
        if (root == null) {
            return null;
        }
        if (root.data == node) {
            return root;
        }

        Node left = solve(root.left, node, arr);
        Node right = solve(root.right, node, arr);

        if (left != null && right == null) {
            arr[0] = arr[0] - 1;
            if (arr[0] <= 0) {
                arr[0] = Integer.MAX_VALUE;
                return root;
            }

            return left;
        }
        if (right != null && left == null) {
            arr[0] = arr[0] - 1;
            if (arr[0] <= 0) {
                arr[0] = Integer.MAX_VALUE;
                return root;
            }

            return right;
        }
        return null;

    }
}

// second method using array list
class k2 {
    public int kthAncestor(Node root, int k, int node) {
        int arr[] = new int[1];
        arr[0] = -2;
        ArrayList<Integer> s = new ArrayList<>();
        rec(root, k, node, arr, s);
        return arr[0];
    }

    public static void rec(Node root, int k, int node, int arr[], ArrayList<Integer> s) {
        if (root == null) {
            return;
        }
        s.add(root.data);
        if (root.data == node) {
            if (s.size() - 1 - k < 0) {
                arr[0] = -1;
                return;
            }
            arr[0] = s.get(s.size() - 1 - k);
            return;
        }
        rec(root.left, k, node, arr, s);
        rec(root.right, k, node, arr, s);
        s.remove(s.size() - 1);

    }
}
