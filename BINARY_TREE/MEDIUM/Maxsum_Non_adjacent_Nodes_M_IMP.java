package BINARY_TREE.MEDIUM;

import java.util.*;

//https://www.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1
// class Node {
//     int data;
//     Node left, right;

//     Node(int data) {
//         this.data = data;
//         this.left = null;
//         this.right = null;
//     }
// }

class Nonadjacent {
    static Map<Node, Integer> m = new HashMap<>();

    int getMaxSum(Node root) {
        // Base case: if the root is null, return 0
        if (root == null)
            return 0;

        // If the result for the current node is already computed, return it
        if (m.containsKey(root))
            return m.get(root);

        // Calculate the sum with the current node
        int withNode = root.data;
        // Call grandchildren if they exist
        if (root.left != null) {
            withNode += getMaxSum(root.left.left);
            withNode += getMaxSum(root.left.right);
        }
        if (root.right != null) {
            withNode += getMaxSum(root.right.left);
            withNode += getMaxSum(root.right.right);
        }

        // Calculate the sum without the current node
        int withoutNode = getMaxSum(root.left) + getMaxSum(root.right);

        // Store the maximum sum in the map and return it
        int maxSum = Math.max(withNode, withoutNode);
        m.put(root, maxSum);
        // System.out.println(m);
        return maxSum;
    }
}

// second approch
class Pair {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Nonadjacent2 {
    // Function which returns a pair such that first of the pair
    // indicates maximum sum when data of a node is included and
    // the second when it is not included.
    static Pair maxSumHelper(Node root) {
        // if root is null, we return two zeroes in pair.
        if (root == null) {
            Pair sum = new Pair(0, 0);
            return sum;
        }

        // calling function recursively for left and right subtrees.
        Pair sum1 = maxSumHelper(root.left);
        Pair sum2 = maxSumHelper(root.right);
        Pair sum = new Pair(0, 0);

        // current node is included (Left and right children are not included).
        sum.first = sum1.second + sum2.second + root.data;

        // current node is excluded (Either left or right child is included).
        sum.second = Math.max(sum1.first, sum1.second) +
                Math.max(sum2.first, sum2.second);

        return sum;
    }

    // Function to return the maximum sum of non-adjacent nodes.
    static int getMaxSum(Node root) {
        Pair res = maxSumHelper(root);
        // returning the maximum between the elements in pair(res).
        return Math.max(res.first, res.second);
    }
}