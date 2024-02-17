package BINARY_TREE.MEDIUM;

// https://www.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1
public class Sum_of_nodes {
    public int sumOfLongRootToLeafPath(Node root) {
        if (root == null) {
            return 0;
        }

        int arr[] = new int[2];
        rec(root, arr, 0, 0);
        return arr[0];

    }

    public static void rec(Node root, int arr[], int sum, int length) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (length > arr[1]) {
                arr[0] = sum + root.data;
                arr[1] = length;

            } else if (length == arr[1]) {
                if (arr[0] < sum + root.data) {
                    arr[0] = sum + root.data;
                    arr[1] = length;

                }
            }

        }

        rec(root.left, arr, sum + root.data, length + 1);
        rec(root.right, arr, sum + root.data, length + 1);

    }
}
