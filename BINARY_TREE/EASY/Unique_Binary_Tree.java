package BINARY_TREE.EASY;

//https://www.codingninjas.com/studio/problems/unique-binary-tree_8180906?leftPanelTabValue=PROBLEM
//In the medium section we have constructed preorder and  inorder 
//we need inorder to to find left and right
class isunique {
    public static boolean uniqueBinaryTree(int a, int b) {
        if (a == b) {
            return false;
        } else if (a == 2 || b == 2) {
            return true;
        }

        return false;

    }
}