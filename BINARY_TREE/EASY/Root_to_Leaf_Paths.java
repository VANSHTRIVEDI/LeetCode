package BINARY_TREE.EASY;

import java.util.*;

//https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
//understanding arraylist

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

class RootroLeaf {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        ArrayList<Integer> traversal = new ArrayList<>();
        solve(root, arr, traversal);
        return arr;
    }

    public static void solve(Node root, ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> t) {
        if (root == null) {
            return;
        }
        t.add((int) root.data);

        if (root.left == null && root.right == null) {

            arr.add(new ArrayList<>(t));
            return;
        }
        solve(root.left, arr, new ArrayList<>(t));

        solve(root.right, arr, new ArrayList<>(t));
        t.remove(t.size() - 1);

    }
}

// https://leetcode.com/problems/binary-tree-paths/
// class Solution {
// public List<String> binaryTreePaths(TreeNode root) {
// List<String> arr=new ArrayList<>();
// String traversal="";
// solve(root,arr,traversal);
// return arr;
// }
// public static void solve(TreeNode root,List<String> arr,String t)
// {
// if(root==null)
// {
// return;
// }
// t=t+Integer.toString((int)root.val);
// if(root.left==null && root.right==null)
// {

// arr.add(t);
// return;
// }
// solve(root.left,arr,t+"->");
// solve(root.right,arr,t+"->");

// }
// }
