package BINARY_TREE.MEDIUM;

//https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
// /https://www.youtube.com/watch?v=FK-Fztwj2gM&list=PLpIkg8OmuX-K23LhcamOcDlTBisiNJy5E
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
class Psedo2 {
    static int count;

    public int pseudoPalindromicPaths(TreeNode root) {
        count = 0;
        solve(root, 0);
        return count;
    }

    public static void solve(TreeNode root, int cout) {
        if (root == null) {
            return;
        }

        // 1 << root.val This statement shifts 1 left root.val number of times
        // then we are doing cout^ "^"because xor elimates duplicate numbers
        cout = (cout ^ (1 << root.val));
        if (root.left == null && root.right == null) {

            // we are checking where the coutbit is a power of 2
            // because when the bit is in power of 2 it has only one 1(odd)
            if ((cout & (cout - 1)) == 0) {
                count++;
            }

        }
        solve(root.left, cout);
        solve(root.right, cout);

    }
}