package BInary_Search_Tree.MEDIUM;

//This is not one question this is combination of questions 

//in this we will learn three concept
//1.bst to sorted double linklist
//2.merge two sorted doubel linklist
//3.convert the marged linklist to bst 
import java.util.*;

class inone {
    static Node head = null;
    static Node head2 = null;
    static Node newhead = null;

    // main function
    public List<Integer> merge(Node root1, Node root2) {
        bstToSortedDLL(root1);
        if (head != null) {
            head.left = null; // Ensure leftmost node has left pointer null
        }
        Node headroot1 = head;

        bstToSortedDLL2(root2);
        if (head2 != null) {
            head2.left = null; // Ensure leftmost node has left pointer null
        }
        Node headroot2 = head2;

        Node newRoot = mergeTwoLinkedLists(headroot1, headroot2);

        int n = countNumberOfNodes(newRoot);
        newhead = newRoot;

        List<Integer> result = new ArrayList<>();
        inOrderTraversal(result, lltobst(n));

        return result;
    }

    // BST to sorted doubly linked list
    public static void bstToSortedDLL(Node root) {
        if (root == null) {
            return;
        }

        bstToSortedDLL(root.right);

        root.right = head;
        if (head != null) {
            head.left = root;
        }
        head = root;

        bstToSortedDLL(root.left);
    }

    // BST to sorted doubly linked list for second node
    public static void bstToSortedDLL2(Node root) {
        if (root == null) {
            return;
        }

        bstToSortedDLL2(root.right);

        root.right = head2;
        if (head2 != null) {
            head2.left = root;
        }
        head2 = root;

        bstToSortedDLL2(root.left);
    }

    // we have made two function above this below function will do work of both in
    // one

    // public static void bstToSortedDLL3(Node root, boolean isFirst) {
    // if (root == null) {
    // return;
    // }

    // bstToSortedDLL(root.right, isFirst);

    // if (isFirst) {
    // root.right = head;
    // if (head != null) {
    // head.left = root;
    // }
    // head = root;
    // } else {
    // root.right = head2;
    // if (head2 != null) {
    // head2.left = root;
    // }
    // head2 = root;
    // }

    // bstToSortedDLL(root.left, isFirst);
    // }

    // Merge two sorted doubly linked lists
    public static Node mergeTwoLinkedLists(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                tail.right = head1;
                head1.left = tail;
                head1 = head1.right;
            } else {
                tail.right = head2;
                head2.left = tail;
                head2 = head2.right;
            }
            tail = tail.right;
        }

        if (head1 != null) {
            tail.right = head1;
            head1.left = tail;
        } else if (head2 != null) {
            tail.right = head2;
            head2.left = tail;
        }

        return dummy.right;
    }

    // Count number of nodes in sorted doubly linked list
    public static int countNumberOfNodes(Node newRoot) {
        int count = 0;
        while (newRoot != null) {
            count++;
            newRoot = newRoot.right;
        }
        return count;
    }

    // Link list to BST
    public static Node lltobst(int n) {
        if (newhead == null || n <= 0) {
            return null;
        }

        Node left = lltobst(n / 2);

        Node root = new Node(newhead.data);
        root.left = left;

        newhead = newhead.right;

        root.right = lltobst(n - 1 - n / 2);

        return root;
    }

    // In-order traversal to retrieve node values
    public static void inOrderTraversal(List<Integer> result, Node root) {
        if (root != null) {
            inOrderTraversal(result, root.left);
            result.add(root.data);
            inOrderTraversal(result, root.right);
        }
    }
}
