package BInary_Search_Tree.MEDIUM;

//https://www.codingninjas.com/studio/problems/flatten-bst-to-a-sorted-list_1169459?leftPanelTab=0&leftPanelTabValue=PROBLEM

class TreeNode<T> {
    public T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

// my way
class flattenbst {
    static TreeNode head = null;

    public static TreeNode<Integer> flatten(TreeNode<Integer> root) {
        // Write your code here
        TreeNode arr[] = { null };
        findHead(root, arr);
        solve(root);
        return arr[0];
    }

    public static void findHead(TreeNode root, TreeNode[] arr) {
        while (root.left != null) {
            root = root.left;
        }

        arr[0] = root;
        head = root;
    }

    public static void solve(TreeNode root) {
        if (root == null) {
            return;
        }
        solve(root.left);

        if (head != root) {
            head.right = root;
            root.left = null;
            head = root;
        }
        solve(root.right);
    }
}
