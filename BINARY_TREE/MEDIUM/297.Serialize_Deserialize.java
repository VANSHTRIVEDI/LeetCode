package BINARY_TREE.MEDIUM;

import java.util.*;;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

//this is using striver string builder  passing 33%
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "")
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// this is my code using string
// passing 11%
class Codec2 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }
        String ss = "";
        ss = ss + Integer.toString((int) root.val) + " ";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left != null) {
                ss = ss + Integer.toString((int) current.left.val) + " ";
                queue.offer(current.left);
            }
            if (current.left == null) {
                ss = ss + "N ";
            }

            if (current.right != null) {
                ss = ss + Integer.toString((int) current.right.val) + " ";
                queue.offer(current.right);
            }
            if (current.right == null) {
                ss = ss + "N ";
            }
        }

        return ss;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] stringArray = data.split(" ");
        if (data.length() == 0) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.valueOf(stringArray[0]));
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int i = 1;

            while (!q.isEmpty()) {
                TreeNode temp = q.poll();

                if (!stringArray[i].equals("N")) {
                    int p = Integer.parseInt(stringArray[i]);
                    temp.left = new TreeNode(p);
                    q.offer(temp.left);
                }
                i++;
                if (!stringArray[i].equals("N")) {
                    temp.right = new TreeNode(Integer.valueOf(stringArray[i]));
                    q.offer(temp.right);
                }
                i++;

            }
            return root;

        }

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
