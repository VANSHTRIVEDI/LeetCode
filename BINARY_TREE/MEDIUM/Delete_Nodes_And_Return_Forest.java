package BINARY_TREE.MEDIUM;

//https://leetcode.com/problems/delete-nodes-and-return-forest/
import java.util.*;

class Delete {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        int size = to_delete.length;
        List<TreeNode> arr = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(to_delete[i]);
        }

        solve(root, set, arr);
        if (!set.contains((int) root.val)) {
            arr.add(root);
        }
        return arr;
    }

    public static TreeNode solve(TreeNode root, HashSet<Integer> set, List<TreeNode> arr) {
        if (root == null) {
            return null;
        }
        root.left = solve(root.left, set, arr);
        root.right = solve(root.right, set, arr);

        if (set.contains((int) root.val)) {

            if (root.left != null) {
                arr.add(root.left);
            }
            if (root.right != null) {
                arr.add(root.right);
            }
            return null;
        } else {
            return root;
        }
    }
}
