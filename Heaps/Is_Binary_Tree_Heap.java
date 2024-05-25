package Heaps;

public class Is_Binary_Tree_Heap {
    int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int ans = 1 + countNodes(root.left) + countNodes(root.right);
        return ans;
    }

    boolean isCBT(Node root, int index, int totalCount) {
        if (root == null)
            return true;
        if (index >= totalCount)
            return false;
        else {
            boolean left = isCBT(root.left, 2 * index + 1, totalCount);
            boolean right = isCBT(root.right, 2 * index + 2, totalCount);
            return left && right;
        }
    }

    boolean isMaxHeap(Node root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.right == null) {
            return root.data > root.left.data;
        } else {
            boolean left = isMaxHeap(root.left);
            boolean right = isMaxHeap(root.right);
            return (left && right && (root.data > root.left.data && root.data > root.right.data));
        }
    }

    public boolean isHeap(Node root) {
        int index = 0;
        int totalCount = countNodes(root);
        return isCBT(root, index, totalCount) && isMaxHeap(root);
    }
}

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}
