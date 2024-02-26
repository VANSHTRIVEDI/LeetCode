package BINARY_TREE.EASY;

class lcaOfThreeNode {
    public static BinaryTreeNode<Integer> lcaOfThreeNodes(BinaryTreeNode<Integer> root, int node1, int node2,
            int node3) {
        if (root == null)
            return null;

        BinaryTreeNode<Integer>[] arr = new BinaryTreeNode[1];
        arr[0] = null;
        solve(root, node1, node2, node3, arr);

        return arr[0];
    }

    public static int solve(BinaryTreeNode<Integer> root, int node1, int node2, int node3,
            BinaryTreeNode<Integer>[] arr) {
        if (root == null)
            return 0;

        int left = solve(root.left, node1, node2, node3, arr);
        if (arr[0] != null) {
            return left;
        }
        int right = solve(root.right, node1, node2, node3, arr);
        int maxx = left + right;

        if (root.data == node1) {
            maxx++;
        }
        if (root.data == node2) {
            maxx++;
        }
        if (root.data == node3) {
            maxx++;
        }

        if (maxx == 3 && arr[0] == null) {
            arr[0] = root;
        }

        return maxx;
    }
}

// this is mutliple nodes

// int getKeysCount(TreeNode *root, vector<int> &keyNodes,
// int matchingNodes,
// vector<TreeNode *> &ancestors)
// {

// // Base Case. When root is Null
// if (root == NULL)
// {
// return 0;
// }

// // Search for left and right subtree
// // for matching child Key Node.
// matchingNodes += getKeysCount(root->left, keyNodes,
// matchingNodes, ancestors) +
// getKeysCount(root->right, keyNodes,
// matchingNodes, ancestors);

// // Condition to check if Root Node
// // is also in Key Node
// if (find(keyNodes.begin(),
// keyNodes.end(), root->data) != keyNodes.end())
// {
// matchingNodes++;
// }

// // Condition when matching Nodes is
// // equal to the Key Nodes found
// if (matchingNodes == keyNodes.size())
// {
// ancestors.push_back(root);
// }

// return matchingNodes;
// }
