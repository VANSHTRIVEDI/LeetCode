package BINARY_TREE.MEDIUM;

import java.util.*;;

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

class Solution {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> listOfLists = new ArrayList<>();

		if (root == null) {
			return listOfLists;
		} else {

			Queue<TreeNode> q = new LinkedList<>();
			boolean lefttoright = true;
			q.add(root);
			while (!q.isEmpty()) {
				ArrayList<Integer> p = new ArrayList<>();
				int size = q.size();
				int arr[] = new int[size];
				for (int i = 0; i < size; i++) {
					TreeNode temp = q.remove();

					int index = lefttoright ? i : size - i - 1;
					arr[index] = temp.val;

					if (temp.left != null) {
						q.add(temp.left);
					}

					if (temp.right != null) {
						q.add(temp.right);
					}
				}
				lefttoright = !lefttoright;
				for (int i = 0; i < size; i++) {
					p.add(arr[i]);
				}
				listOfLists.add(p);

			}
			return listOfLists;

		}

	}
}
