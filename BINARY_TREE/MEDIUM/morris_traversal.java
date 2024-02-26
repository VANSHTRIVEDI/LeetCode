package BINARY_TREE.MEDIUM;

import java.util.*;

//https://leetcode.com/problems/binary-tree-inorder-traversal/
////we are using morris traversal o(n)time and o(1) space
//only traversal which uses o(1) space time which is good
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class morrisInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();

        if (root == null) {
            return arr;
        }

        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                arr.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                }

                if (prev.right == cur) {
                    prev.right = null;
                    arr.add(cur.val);
                    cur = cur.right;
                }

            }
        }
        return arr;
    }
}

// https://www.geeksforgeeks.org/problems/preorder-traversal-iterative/1

class morrisPreorderTraversal {
    // Return a list containing the Preorder traversal of the given tree
    ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (root == null) {
            return arr;
        }

        Node cur = root;

        while (cur != null) {

            if (cur.left == null) {
                arr.add(cur.data);
                cur = cur.right;
            } else {
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    arr.add(cur.data);
                    cur = cur.left;
                }

                if (prev.right == cur) {
                    prev.right = null;

                    cur = cur.right;
                }

            }
        }

        return arr;
    }

}