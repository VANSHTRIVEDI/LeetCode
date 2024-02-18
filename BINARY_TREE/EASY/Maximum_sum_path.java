package BINARY_TREE.EASY;

import java.util.*;
//https://www.codingninjas.com/studio/problems/maximum-sum-path-from-the-leaf-to-root_975299

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

// fist solution
public class Maximum_sum_path {
    public static List<Integer> maxSum(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> auu = new ArrayList<>();
        int sum = 0;
        int[] pp = new int[1];
        pp[0] = Integer.MIN_VALUE;
        rec(root, arr, auu, sum, pp);
        Collections.reverse(auu);
        return auu;
    }

    public static void rec(BinaryTreeNode<Integer> root, ArrayList<Integer> arr, ArrayList<Integer> auu, int sum,
            int[] pp) {
        if (root == null) {

            return;
        }
        if (root.left == null && root.right == null) {
            if (sum + root.data > pp[0]) {
                pp[0] = sum + root.data;
                auu.clear();
                auu.addAll(arr);
                auu.add(root.data);
            }
            return;

        }
        arr.add(root.data);
        rec(root.left, arr, auu, sum + root.data, pp);
        rec(root.right, arr, auu, sum + root.data, pp);
        arr.remove(arr.size() - 1);

    }
}

// second solution not passing all the testcases
class hehe2 {
    public static List<Integer> maxSum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            List<Integer> ans = new ArrayList<Integer>();
            return ans;
        }

        List<Integer> leftPath = maxSum(root.left);
        List<Integer> rightPath = maxSum(root.right);

        leftPath.add(root.data);
        rightPath.add(root.data);

        int leftSum = 0, rightSum = 0;

        for (int i = 0; i < leftPath.size(); i++) {
            leftSum += leftPath.get(i);
        }
        for (int i = 0; i < rightPath.size(); i++) {
            rightSum += rightPath.get(i);
        }

        if ((leftSum >= rightSum && root.left != null) || root.right == null) {
            return leftPath;
        }

        return rightPath;
    }
}