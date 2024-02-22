package BINARY_TREE.MEDIUM;

import java.util.*;
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

class Construct {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int inorderstart = 0;
        int inorderend = inorder.length - 1;
        int preindex[] = new int[1];
        preindex[0] = 0;
        TreeNode ans = solve(preorder, inorder, inorderstart, inorderend, preorder.length, preindex);
        return ans;
    }

    public static TreeNode solve(int[] preorder, int[] inorder, int inorderstart, int inorderend, int preorderlengtth,
            int preindex[]) {
        if (inorderstart > inorderend || preindex[0] >= preorderlengtth) {
            return null;
        }

        int element = preorder[preindex[0]];
        TreeNode temp = new TreeNode(element);
        preindex[0] = preindex[0] + 1;
        int p = 0;
        for (int i = inorderstart; i <= inorderend; i++) {
            if (inorder[i] == element) {
                p = i;
                break;
            }

        }
        temp.left = solve(preorder, inorder, inorderstart, p - 1, preorder.length, preindex);
        temp.right = solve(preorder, inorder, p + 1, inorderend, preorder.length, preindex);

        return temp;

    }

}

// Better Approch Using map while finding p

class Construct2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int inorderstart = 0;
        int inorderend = inorder.length - 1;
        int preindex[] = new int[1];
        preindex[0] = 0;
        TreeNode ans = solve(preorder, inorder, inorderstart, inorderend, preorder.length, preindex, map);
        return ans;
    }

    public static TreeNode solve(int[] preorder, int[] inorder, int inorderstart, int inorderend, int preorderlengtth,
            int preindex[], HashMap<Integer, Integer> map) {
        if (inorderstart > inorderend || preindex[0] >= preorderlengtth) {
            return null;
        }

        int element = preorder[preindex[0]];
        TreeNode temp = new TreeNode(element);
        preindex[0] = preindex[0] + 1;
        int p = 0;

        // using map
        p = map.get(element);
        temp.left = solve(preorder, inorder, inorderstart, p - 1, preorder.length, preindex, map);
        temp.right = solve(preorder, inorder, p + 1, inorderend, preorder.length, preindex, map);

        return temp;

    }

}