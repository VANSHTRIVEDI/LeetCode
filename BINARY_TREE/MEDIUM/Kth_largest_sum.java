package BINARY_TREE.MEDIUM;

//https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/
import java.util.*;

//using PriorityQueue with Comparator
//better way 
class largesttt {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> p = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.isEmpty() == false) {
            int n = q.size();
            long sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode t = q.peek();
                q.poll();
                if (t.left != null)
                    q.offer(t.left);
                if (t.right != null)
                    q.offer(t.right);
                sum += t.val;
            }
            p.add(sum);
        }
        while (k > 1 && !p.isEmpty()) {
            k--;
            p.poll();
        }
        if (p.isEmpty())
            return -1;
        return p.peek();
    }
}

// using only PriorityQueue best way
class largesttt2 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<Long> heap = new PriorityQueue<>();
        Queue<TreeNode> levels = new ArrayDeque<>();
        levels.offer(root);

        while (!levels.isEmpty()) {
            long sum = 0;
            int size = levels.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = levels.poll();
                sum += node.val;

                if (node.left != null)
                    levels.offer(node.left);
                if (node.right != null)
                    levels.offer(node.right);
            }

            if (heap.size() < k) {
                heap.offer(sum);
            } else if (heap.peek() < sum) {
                heap.poll();
                heap.offer(sum);
            }
        }

        return heap.size() < k ? -1 : heap.peek();
    }
}

// using arraylist
class largesttt3 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        ArrayList<Long> arr = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                sum = sum + (long) temp.val;

                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
            arr.add(sum);
        }
        if (arr.size() < k) {
            return -1;
        } else {
            Collections.sort(arr);
            return arr.get(arr.size() - k);
        }
    }
}
