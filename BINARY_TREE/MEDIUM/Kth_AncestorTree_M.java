package BINARY_TREE.MEDIUM;

//https://www.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1
import java.util.*;

class Kth_AncestorTree_M {
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
        if (arr[0] != -2) {
            return;
        }
        rec(root.left, k, node, arr, s);
        if (arr[0] != -2) {
            return;
        }
        rec(root.right, k, node, arr, s);
        s.remove(s.size() - 1);

    }
}
