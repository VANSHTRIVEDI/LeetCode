package BInary_Search_Tree.MEDIUM;

// /https://leetcode.com/problems/recover-binary-search-tree/
import java.util.*;

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

// better appraoch without using arraylist
class Recover {
    static TreeNode prev;
    static TreeNode first;
    static TreeNode last;

    public void recoverTree(TreeNode root) {
        prev = first = last = null;
        inorder(root);
        int t = (int) first.val;
        first.val = last.val;
        last.val = t;

    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);

        if (prev != null && ((int) prev.val > (int) root.val)) {
            if (first == null) {
                first = prev;
                last = root;
            } else {
                last = root;
            }

        }

        prev = root;
        inorder(root.right);
    }
}

// same apprach using morris traversal
class Recover3 {
    public void recoverTree(TreeNode root) {
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode last = null;

        // Morris Traversal
        TreeNode current = root;
        TreeNode temp = null;

        while (current != null) {
            if (current.left == null) {
                if (prev != null && prev.val > current.val) {
                    if (first == null) {
                        first = prev;
                        last = current;
                    } else {
                        last = current;
                    }
                }
                prev = current;
                current = current.right;
            } else {
                // Find the inorder predecessor of current
                temp = current.left;
                while (temp.right != null && temp.right != current) {
                    temp = temp.right;
                }

                // Make current as the right child of its inorder predecessor
                if (temp.right == null) {
                    temp.right = current;
                    current = current.left;
                } else {
                    // Revert the changes made in the 'if' part to restore the original tree
                    temp.right = null;
                    if (prev != null && prev.val > current.val) {
                        if (first == null) {
                            first = prev;
                            last = current;
                        } else {
                            last = current;
                        }
                    }
                    prev = current;
                    current = current.right;
                }
            }
        }

        // Swap the values of the first and last elements found
        int tempVal = first.val;
        first.val = last.val;
        last.val = tempVal;
    }
}

// using ArrayList
class Recover2 {
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> arr = new ArrayList<>();

        // inorder
        inorder(arr, root);

        TreeNode start = arr.get(0);
        TreeNode end = arr.get(arr.size() - 1);
        // apply two pointer
        int s = 0;
        int e = arr.size() - 1;

        while (s <= arr.size() - 1 && arr.get(s).val < arr.get(s + 1).val) {
            s++;
            start = arr.get(s);

        }
        while (e >= 0 && arr.get(e).val > arr.get(e - 1).val) {

            e--;
            end = arr.get(e);
        }

        int t = (int) start.val;
        start.val = end.val;
        end.val = t;
    }

    public static void inorder(ArrayList<TreeNode> arr, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(arr, root.left);
        arr.add(root);
        inorder(arr, root.right);
    }
}
