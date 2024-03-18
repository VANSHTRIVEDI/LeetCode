package BINARY_TREE.MEDIUM;

import java.util.*;

//https://leetcode.com/problems/validate-binary-tree-nodes/submissions/1207248861/
//https://www.youtube.com/watch?v=JlQEoNs263o&list=PLpIkg8OmuX-K23LhcamOcDlTBisiNJy5E&index=30
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
                if (root != -1) {
                    return false;
                } else {
                    root = i;
                }
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