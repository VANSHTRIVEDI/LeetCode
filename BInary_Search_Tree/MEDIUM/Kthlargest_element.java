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

// class Solution {
// public static int KthLargestNumber(TreeNode<Integer> root, int k) {
// int[] count = {0};
// return findKthlargest(root, k, count);
// }
// private static int findKthlargest(TreeNode<Integer> root, int k, int[] count)
// {
// if (root == null) {
// return -1;
// }

// int right = findKthlargest(root.right, k, count);
// if (right != -1) {
// return right;
// }

// count[0]++;
// if (count[0] == k) {
// return root.data;
// }

// int left= findKthlargest(root.left, k, count);

// return left;
// }
// }