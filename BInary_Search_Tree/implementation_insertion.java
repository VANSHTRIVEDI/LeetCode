package BInary_Search_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class implementation_insertion {

    public static void main(String args[]) {
        Node root = null;
        System.out.println("Enter Data to create Bts");
        root = createroot(root);
        System.err.println("PRINTING THE BST" + root.data + " " + root.left.data);

        levelOrderinsertion(root);

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
