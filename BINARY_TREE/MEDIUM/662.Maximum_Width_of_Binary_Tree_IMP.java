package BINARY_TREE.MEDIUM;

import java.util.*;

//https://leetcode.com/problems/maximum-width-of-binary-tree/

//This is how indexing is done in the below method
// 1
// 1 2 
// 1 2 3 4

//This kind of indexing will now course any stackover flow if the level of the tree is very large above 10^5
//bacause as we are goind down one level the double of previous level is coming in other method 

//this is best indexing method
class maxwidht {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));
        int max = 0;
        while (!q.isEmpty()) {
            int left = -1;
            int right = -1;

            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair node = q.remove();
                TreeNode temp = node.node;

                int index = node.index;
                if (temp.left != null) {
                    // this cocept of indexing is very important
                    q.offer(new Pair(temp.left, (2 * index) - 1));
                }
                if (temp.right != null) {
                    q.offer(new Pair(temp.right, (2 * index)));
                }
                if (i == 0) {
                    left = index;
                }
                if (i == size - 1) {
                    right = index;
                }
            }
            max = Math.max(max, (right - left) + 1);

        }
        return max;
    }
}

class Pair {
    TreeNode node;
    Integer index;

    Pair(TreeNode noe, Integer i) {
        this.node = noe;
        this.index = i;
    }

}

// this same just that indexing is changes

// 0
// 1 2
// 3 4 5 6
// 7 8 9 10
class maxwidht2 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int max = 0;
        while (!q.isEmpty()) {
            int left = -1;
            int right = -1;

            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair node = q.remove();
                TreeNode temp = node.node;
                int index = node.index;
                if (temp.left != null) {
                    q.offer(new Pair(temp.left, (2 * index) + 1));
                }
                if (temp.right != null) {
                    q.offer(new Pair(temp.right, (2 * index) + 2));
                }
                if (i == 0) {
                    left = index;
                }
                if (i == size - 1) {
                    right = index;
                }
            }
            max = Math.max(max, (right - left) + 1);

        }
        return max;
    }
}
