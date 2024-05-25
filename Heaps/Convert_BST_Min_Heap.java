package Heaps;

import java.util.ArrayList;

class BinaryTreeNode {

    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

// to make bst to min heap we use preorder
// to make bst to max heap we use postorder
public class Convert_BST_Min_Heap {
    static ArrayList<Integer> arr;
    static int i;

    public static BinaryTreeNode convertBST(BinaryTreeNode root) {
        arr = new ArrayList<Integer>();
        i = 0;

        bstToArray(root, arr);
        if (root == null) {
            return null;
        }

        preOrderTraversal(root);
        return root;
    }

    public static void preOrderTraversal(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        // Visit the root node
        node.data = arr.get(i++);

        // Traverse the left subtree
        preOrderTraversal(node.left);

        // Traverse the right subtree
        preOrderTraversal(node.right);
    }

    private static void bstToArray(BinaryTreeNode root, ArrayList<Integer> arr) {
        // ArrayLIst stores elements in inorder fashion
        if (root == null)
            return;

        bstToArray(root.left, arr);

        arr.add(root.data);

        bstToArray(root.right, arr);
    }
}
