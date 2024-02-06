package BINARY_TREE.MEDIUM;

//https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
import java.util.*;;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

// Better Solution Using if else in recursion
class Solution2 {
    ArrayList<Integer> boundary(Node node) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(node.data);
        if (node.left == null && node.right == null) {
            return list;
        }

        left(node.left, list);
        b(node.left, list);
        b(node.right, list);
        right(node.right, list);

        return list;

    }

    public static void left(Node root, ArrayList<Integer> list) {
        if ((root == null) || (root.left == null && root.right == null)) {
            return;
        }

        list.add(root.data);
        if (root.left != null) {
            left(root.left, list);
        } else {
            left(root.right, list);
        }

    }

    public static void b(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.data);
            return;
        }
        b(root.left, list);
        b(root.right, list);
    }

    public static void right(Node root, ArrayList<Integer> list) {
        if ((root == null) || (root.left == null && root.right == null)) {
            return;
        }

        if (root.right != null) {
            right(root.right, list);

        } else {
            right(root.left, list);
        }
        list.add(root.data);
    }
}

class Solution {
    ArrayList<Integer> boundary(Node node) {
        int arr[] = new int[2];
        ArrayList<Integer> list = new ArrayList<Integer>();
        Node address[] = new Node[2];

        list.add(node.data);
        if (node.left == null && node.right == null) {
            return list;
        }
        left(node.left, list, arr, address);
        b(node, list, arr, address);
        arr[0] = 0;
        right(node.right, list, arr, address);

        return list;

    }

    public static void left(Node root, ArrayList<Integer> list, int arr[], Node address[]) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            arr[0] = 1;

        }

        address[1] = root;
        if (arr[0] != 1) {
            if (root.left != null || root.right != null) {
                list.add(root.data);
            }
        }

        left(root.left, list, arr, address);
        left(root.right, list, arr, address);

    }

    public static void b(Node root, ArrayList<Integer> list, int arr[], Node address[]) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {

            // arr[0]=-1;
            address[0] = root;

            list.add(root.data);

            return;
        }
        b(root.left, list, arr, address);
        b(root.right, list, arr, address);
    }

    public static void right(Node root, ArrayList<Integer> list, int arr[], Node address[]) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            arr[0] = 1;
            return;
        }
        if (arr[0] == 1) {
            return;
        }
        right(root.right, list, arr, address);
        right(root.left, list, arr, address);
        if (root.left != null || root.right != null) {
            list.add(root.data);
        }
    }
}

// //{ Driver Code Starts
// import java.io.*;
// import java.util.*;

// class Node
// {
// int data;
// Node left, right;

// public Node(int d)
// {
// data = d;
// left = right = null;
// }
// }

// class GFG
// {
// static Node buildTree(String str)
// {
// // Corner Case
// if(str.length() == 0 || str.equals('N'))
// return null;
// String[] s = str.split(" ");

// Node root = new Node(Integer.parseInt(s[0]));
// Queue <Node> q = new LinkedList<Node>();
// q.add(root);

// // Starting from the second element
// int i = 1;
// while(!q.isEmpty() && i < s.length)
// {
// // Get and remove the front of the queue
// Node currNode = q.remove();

// // Get the current node's value from the string
// String currVal = s[i];

// // If the left child is not null
// if(!currVal.equals("N"))
// {

// // Create the left child for the current node
// currNode.left = new Node(Integer.parseInt(currVal));

// // Push it to the queue
// q.add(currNode.left);
// }

// // For the right child
// i++;
// if(i >= s.length)
// break;
// currVal = s[i];

// // If the right child is not null
// if(!currVal.equals("N"))
// {

// // Create the right child for the current node
// currNode.right = new Node(Integer.parseInt(currVal));

// // Push it to the queue
// q.add(currNode.right);
// }

// i++;
// }

// return root;
// }

// public static void main(String args[]) throws IOException {

// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// int t = Integer.parseInt(br.readLine().trim());
// while(t>0)
// {
// String s = br.readLine();
// Node root = buildTree(s);

// Solution T = new Solution();

// ArrayList <Integer> res = T.boundary(root);
// for (Integer num : res) System.out.print (num + " ");
// System.out.println();
// t--;
// }
// }
// }

// }
