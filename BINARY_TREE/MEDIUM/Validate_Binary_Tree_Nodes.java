package BINARY_TREE.MEDIUM;

import java.util.*;

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer, Integer> childToParent = new HashMap<>();
        Map<Integer, List<Integer>> parentTochild = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int left = leftChild[i];
            int right = rightChild[i];

            if (left != -1) {
                if (childToParent.containsKey(left)) {
                    return false;
                }
                List<Integer> childrenList = parentTochild.getOrDefault(i, new ArrayList<>());
                childrenList.add(left);
                parentTochild.put(i, childrenList);
                childToParent.put(left, i);
            }
            if (right != -1) {
                if (childToParent.containsKey(right)) {
                    return false;
                }
                List<Integer> childrenList = parentTochild.getOrDefault(i, new ArrayList<>());
                childrenList.add(right);
                parentTochild.put(i, childrenList);
                childToParent.put(right, i);
            }

        }
        // System.out.println(parentTochild);
        // System.out.println(childToParent);
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (childToParent.containsKey(i)) {
                continue;
            } else {
                root = i;
            }

        }
        if (root == -1) {
            return false;
        }

        Queue<Integer> q = new LinkedList<>();
        // boolean[] visited = new boolean[n];
        int count = 1;
        q.add(root);
        // visited[root] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int child : parentTochild.getOrDefault(node, Collections.emptyList())) {
                // System.out.println(child);
                // if (!visited[child])
                // {
                // visited[child] = true;
                count++;
                q.add(child);
                // }
            }
        }

        return count == n;

    }

}