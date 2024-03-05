package BInary_Search_Tree.MEDIUM;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/problems/predecessor-and-successor/1
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
};

class PredandSucc {

    // most important best way
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        TreeNode temp = root;
        int pred = -1;
        int succ = -1;

        while (temp != null) {
            if ((int) temp.data > key) {
                succ = (int) temp.data;
                temp = temp.left;

            } else if (temp.data < key) {
                pred = (int) temp.data;
                temp = temp.right;

            } else {

                if (temp.left != null) {
                    TreeNode preee = temp.left;
                    while (preee.right != null) {
                        preee = preee.right;
                    }
                    pred = (int) preee.data;
                }

                if (temp.right != null) {
                    TreeNode succc = temp.right;
                    while (succc.left != null) {
                        succc = succc.left;
                    }
                    succ = (int) succc.data;
                }
                break;
            }
        }
        List<Integer> arr = new ArrayList<>();
        arr.add(pred);
        arr.add(succ);
        return arr;

    }
}
