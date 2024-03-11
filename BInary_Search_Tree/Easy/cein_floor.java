package BInary_Search_Tree.Easy;

//https://www.codingninjas.com/studio/problems/ceil-from-bst_920464?count=25&page=12&search=&sort_entity=order&sort_order=ASC&leftPanelTabValue=PROBLEM
class ceil {

    public static int findCeil(TreeNode<Integer> node, int x) {
        int pred = -1;
        int succ = -1;

        while (node != null) {
            if (node.data < x) {
                pred = node.data;
                node = node.right;
            } else {
                succ = node.data;
                node = node.left;
            }
        }

        return succ;

    }
}

class TreeNode<T> {

    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

// /https://www.codingninjas.com/studio/problems/floor-from-bst_625868?leftPanelTabValue=SUBMISSION
class solution {
    public static int Floor(TreeNode<Integer> node, int x) {
        int pred = -1;
        int succ = -1;

        while (node != null) {
            if ((int) node.data < x) {
                pred = (int) node.data;
                node = node.right;
            } else if ((int) node.data > x) {
                succ = (int) node.data;
                node = node.left;
            } else {
                pred = node.data;
                break;
            }
        }

        return pred;

    }

}
