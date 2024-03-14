package BINARY_TREE.HARD;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/

//This problem is on the concept of diameter of tree which is related to height of the tree
//we you are able to solve diameter of tree you can solve this tooo

// class Node {
//     int data;
//     Node left, right;

//     Node(int d) {
//         data = d;
//         left = right = null;
//     }
// }

class maximumpathsum {
    // Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node root) {
        int arr[] = new int[1];
        arr[0] = Integer.MIN_VALUE;
        solve(root, arr);
        return arr[0];
    }

    public static int solve(Node root, int arr[]) {
        if (root == null) {
            return 0;
        }
        int leftsum = Math.max(0, solve(root.left, arr));
        int rightsum = Math.max(0, solve(root.right, arr));
        arr[0] = Math.max(arr[0], leftsum + rightsum + root.data);

        return Math.max(leftsum, rightsum) + root.data;

    }
}
