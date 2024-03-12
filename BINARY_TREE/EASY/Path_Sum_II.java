package BINARY_TREE.EASY;

import java.util.*;;

//https://leetcode.com/problems/path-sum-ii/
class Solution {
    static List<List<Integer>> list;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        list = new ArrayList<>();
        solve(root, targetSum, new ArrayList<>(), 0);
        return list;
    }

    public static void solve(TreeNode root, int targetSum, List<Integer> arr, int count) {
        if (root == null)
            return;

        count += root.val;
        arr.add(root.val);

        if (count == targetSum && root.left == null && root.right == null) {
            list.add(new ArrayList<>(arr));
        }

        solve(root.left, targetSum, arr, count);
        solve(root.right, targetSum, arr, count);

        // Backtrack - remove the last element from the list
        arr.remove(arr.size() - 1);
    }
}
