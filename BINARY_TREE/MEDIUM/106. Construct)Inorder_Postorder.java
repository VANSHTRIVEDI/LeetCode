package BINARY_TREE.MEDIUM;

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
import java.util.*;;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class construct {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int inorderend = inorder.length - 1;
        int inorderstart = 0;
        int postindex[] = new int[1];
        postindex[0] = postorder.length - 1;
        TreeNode ans = rec(inorder, postorder, inorderend, inorderstart, postindex, map);
        return ans;
    }

    public static TreeNode rec(int in[], int post[], int inorderend, int inorderstart, int postindex[],
            HashMap<Integer, Integer> map) {

        if (postindex[0] < 0 || inorderstart > inorderend) {
            return null;
        }
        int element = post[postindex[0]];
        postindex[0] = postindex[0] - 1;

        TreeNode temp = new TreeNode(element);

        int p = 0;
        p = map.get(element);
        temp.right = rec(in, post, inorderend, p + 1, postindex, map);
        temp.left = rec(in, post, p - 1, inorderstart, postindex, map);

        return temp;
    }
}
