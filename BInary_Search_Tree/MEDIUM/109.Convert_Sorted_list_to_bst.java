package BInary_Search_Tree.MEDIUM;
// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/

// class con {
// static ListNode headd=null;
// public TreeNode sortedListToBST(ListNode head) {
// int n = countNumberOfNodes(head);
// headd=head;
// return convertListToBST(n);
// }

// private int countNumberOfNodes(ListNode head) {
// int count = 0;
// while (head != null) {
// count++;
// head = head.next;
// }
// return count;
// }

// private TreeNode convertListToBST(int n) {
// if (headd == null || n <= 0) {
// return null;
// }

// TreeNode left = convertListToBST( n / 2);

// TreeNode root = new TreeNode((int) headd.val);
// root.left = left;

// headd = headd.next;

// root.right = convertListToBST( n - 1 - n / 2);

// return root;
// }
// }
