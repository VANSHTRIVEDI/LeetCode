
//https://leetcode.com/problems/insert-into-a-binary-search-tree/
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

// using while loop
class insert {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode pr = root;
        if (root == null) {
            return new TreeNode(val);
        } else {

            while (root != null) {
                if (root.val > val) {
                    if (root.left == null) {
                        root.left = new TreeNode(val);
                        break;
                    }
                    root = root.left;
                } else {
                    if (root.right == null) {
                        root.right = new TreeNode(val);
                        break;
                    }
                    root = root.right;
                }
            }

            return pr;

        }

    }

    // using recursion
    class insert2 {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null)
                return new TreeNode(val);

            if (val > root.val)
                root.right = insertIntoBST(root.right, val);

            else if (val < root.val)
                root.left = insertIntoBST(root.left, val);

            return root;
        }
    }
}
