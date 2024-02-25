package BINARY_TREE.MEDIUM;

//https://www.geeksforgeeks.org/problems/sum-tree/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class sumtree {
    boolean isSumTree(Node root) {
        int t = sum(root);
        if (t == -1) {
            return false;
        }
        return true;
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int left = sum(root.left);
        if (left == -1) {
            return -1;
        }
        int right = sum(root.right);
        if (right == -1) {
            return -1;
        }
        if (left + right == root.data) {
            return left + right + root.data;
        } else if (root.left == null && root.right == null) {
            return root.data;
        }

        return -1;

    }
}

// { Driver Code Starts
// Initial Template for Java

// import java.util.LinkedList;
// import java.util.Queue;
// import java.io.*;
// import java.util.*;

// class Node{
// int data;
// Node left;
// Node right;
// Node(int data){
// this.data = data;
// left=null;
// right=null;
// }
// }

// class GfG {

// static Node buildTree(String str){

// if(str.length()==0 || str.charAt(0)=='N'){
// return null;
// }

// String ip[] = str.split(" ");
// // Create the root of the tree
// Node root = new Node(Integer.parseInt(ip[0]));
// // Push the root to the queue

// Queue<Node> queue = new LinkedList<>();

// queue.add(root);
// // Starting from the second element

// int i = 1;
// while(queue.size()>0 && i < ip.length) {

// // Get and remove the front of the queue
// Node currNode = queue.peek();
// queue.remove();

// // Get the current node's value from the string
// String currVal = ip[i];

// // If the left child is not null
// if(!currVal.equals("N")) {

// // Create the left child for the current node
// currNode.left = new Node(Integer.parseInt(currVal));
// // Push it to the queue
// queue.add(currNode.left);
// }

// // For the right child
// i++;
// if(i >= ip.length)
// break;

// currVal = ip[i];

// // If the right child is not null
// if(!currVal.equals("N")) {

// // Create the right child for the current node
// currNode.right = new Node(Integer.parseInt(currVal));

// // Push it to the queue
// queue.add(currNode.right);
// }
// i++;
// }

// return root;
// }

// public static void main (String[] args) throws IOException{
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int t=Integer.parseInt(br.readLine());

// while(t > 0){
// String s = br.readLine();
// Node root = buildTree(s);
// Solution g = new Solution();

// if(g.isSumTree(root) == true)
// System.out.println(1);
// else
// System.out.println(0);
// t--;

// }
// }

// }

// } Driver Code Ends
