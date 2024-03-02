package BInary_Search_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class implementation_insertion {

    public static void main(String args[]) {
        Node root = null;
        System.out.println("Enter Data to create Bts");
        root = createroot(root);
        System.err.println("LEVEL ORDER PRINTING THE BST");
        levelOrderinsertion(root);
        System.out.println();
        System.err.println("INORDER PRINTING THE BST");
        inordertraversal(root);
        System.out.println();
        System.err.println("PREEORDER PRINTING THE BST");
        preorder(root);
        System.out.println();
        System.err.println("POSTORDER PRINTING THE BST");
        postorder(root);

    }

    public static Node createroot(Node root) {
        Scanner sc = new Scanner(System.in);

        int data;
        data = sc.nextInt();
        while (data != -1) {
            root = insertnode(root, data);
            data = sc.nextInt();
        }
        sc.close();

        return root;
    }

    public static Node insertnode(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data > root.data) {
            root.right = insertnode(root.right, data);
        } else {
            root.left = insertnode(root.left, data);
        }
        return root;

    }

    public static void levelOrderinsertion(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return;
        }
        q.offer(root);
        q.offer(null);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.offer(null);
                }
            } else {
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }

        }

    }

    public static void inordertraversal(Node root) {
        if (root == null) {
            return;
        }
        inordertraversal(root.left);
        System.err.print(root.data + " ");
        inordertraversal(root.right);
    }

    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.err.print(root.data + " ");
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.err.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);

    }

}

class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        this.data = d;
        this.left = null;
        this.right = null;
    }
}
