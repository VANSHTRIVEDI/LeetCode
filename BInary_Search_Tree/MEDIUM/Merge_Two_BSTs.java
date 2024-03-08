package BInary_Search_Tree.MEDIUM;

/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int val) {
         this.data = val;
         this.left = null;
         this.right = null;
     }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.data = val;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.ArrayList;
import java.util.List;
import java.util.*;

//first solution using recursion 
class merge {
    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        fillinoder(root1, arr1);
        fillinoder(root2, arr2);

        return mergetwo(arr1, arr2);
    }

    public static void fillinoder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        fillinoder(root.left, arr);
        arr.add((int) root.val);
        fillinoder(root.right, arr);

    }

    public static List<Integer> mergetwo(List<Integer> arr1, List<Integer> arr2) {
        List<Integer> f = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.size() && j < arr2.size()) {

            if (arr1.get(i) < arr2.get(j)) {
                f.add(arr1.get(i));
                i++;
            } else {
                f.add(arr2.get(j));
                j++;

            }

        }
        while (i < arr1.size()) {
            f.add(arr1.get(i));
            i++;
        }
        while (j < arr2.size()) {
            f.add(arr2.get(j));
            j++;
        }
        return f;
    }
}

// coding ninjas mein 1 testcase stackover dikha rha tha isliya without
// recursion
// logic is same
class merge2 {
    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        fillinoder(root1, arr1);
        fillinoder(root2, arr2);

        return mergetwo(arr1, arr2);
    }

    public static void fillinoder(TreeNode root, List<Integer> arr) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Traverse the left subtree and push nodes onto the stack
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Pop a node from the stack
            current = stack.pop();

            // Add its value to the list
            arr.add((int) current.val);

            // Move to the right subtree
            current = current.right;
        }

    }

    public static List<Integer> mergetwo(List<Integer> arr1, List<Integer> arr2) {
        List<Integer> f = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.size() && j < arr2.size()) {

            if (arr1.get(i) < arr2.get(j)) {
                f.add(arr1.get(i));
                i++;
            } else {
                f.add(arr2.get(j));
                j++;

            }

        }
        while (i < arr1.size()) {
            f.add(arr1.get(i));
            i++;
        }
        while (j < arr2.size()) {
            f.add(arr2.get(j));
            j++;
        }
        return f;
    }
}
