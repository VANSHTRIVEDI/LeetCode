package BINARY_TREE.MEDIUM;

import java.util.*;

//Imp
//https://leetcode.com/problems/path-sum-iii/description/?source=submission-ac

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

// This is a very important uploading using comulative sum
class Path1 {
    int total = 0;

    public int pathSum(TreeNode root, int targetSum) {

        HashMap<Long, Integer> map = new HashMap<>();
        map.put((long) 0, 1);
        rec(map, root, targetSum, 0);
        return total;
    }

    public void rec(HashMap<Long, Integer> map, TreeNode root, int targetSum, long currsum) {
        if (root == null) {
            return;
        }
        currsum += root.val;
        if (map.containsKey(currsum - targetSum)) {
            total = total + map.get(currsum - targetSum);
        }
        map.put(currsum, map.getOrDefault(currsum, 0) + 1);

        rec(map, root.left, targetSum, currsum);
        rec(map, root.right, targetSum, currsum);
        map.put(currsum, map.get(currsum) - 1);

    }
}

class Path2 {
    public int pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> auu = new ArrayList<Integer>();
        int arr[] = new int[1];
        rec(root, targetSum, arr, auu);
        return arr[0];
    }

    public static void rec(TreeNode root, int targetSum, int arr[], ArrayList<Integer> auu) {
        if (root == null) {
            return;
        }
        auu.add(root.val);
        rec(root.left, targetSum, arr, auu);
        rec(root.right, targetSum, arr, auu);

        long sum = 0;
        for (int i = auu.size() - 1; i >= 0; i--) {
            sum = sum + auu.get(i);
            if (sum == targetSum) {
                arr[0] = arr[0] + 1;
            }
        }
        auu.remove(auu.size() - 1);

    }
}
