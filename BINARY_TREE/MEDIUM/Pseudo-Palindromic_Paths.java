package BINARY_TREE.MEDIUM;

//https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/

//using array
class Psedo {
    static int count;

    public int pseudoPalindromicPaths(TreeNode root) {
        count = 0;
        int arr[] = new int[10];
        solve(root, arr);
        return count;
    }

    public static void solve(TreeNode root, int arr[]) {
        if (root == null) {
            return;
        }
        arr[root.val] = arr[root.val] + 1;
        if (root.left == null && root.right == null) {
            int onecount = 0;
            for (int i = 1; i < 10; i++) {
                if (arr[i] % 2 != 0) {
                    onecount++;
                }
            }

            if (onecount <= 1) {
                count++;
            }

        }
        solve(root.left, arr);
        solve(root.right, arr);
        arr[root.val] = arr[root.val] - 1;

    }
}

// using bit manipulation
