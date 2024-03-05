package BInary_Search_Tree.MEDIUM;

//https://www.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
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

// using morrise traversal
class largest {
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root, int k) {
        int i = 0;
        while (root != null) {
            if (root.right == null) {
                i++;
                if (i == k) {
                    return (int) root.data;
                }
                root = root.left;
            } else {
                Node prev = root.right;

                while (prev.left != null && prev.left != root) {
                    prev = prev.left;
                }
                if (prev.left == null) {
                    prev.left = root;
                    root = root.right;
                } else {
                    i++;
                    if (i == k) {
                        return (int) root.data;
                    }
                    prev.left = null;
                    root = root.left;
                }
            }

        }
        return -1;
    }
}

// using normal way

class largest2 {
    public static int KthLargestNumber(Node root, int k) {

        int i = 0;

        while (root != null) {
            if (root.right == null) {
                i++;
                if (i == k) {
                    return (int) root.data;
                }
                root = root.left;
            } else {
                Node prev = root.right;

                while (prev.left != null && prev.left != root) {
                    prev = prev.left;
                }
                if (prev.left == null) {
                    prev.left = root;
                    root = root.right;
                } else {
                    i++;
                    if (i == k) {
                        return (int) root.data;
                    }
                    prev.left = null;
                    root = root.left;
                }
            }

        }
        return -1;
    }
}