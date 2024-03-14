package BINARY_TREE.MEDIUM;

import java.util.*;

//https://leetcode.com/problems/find-duplicate-subtrees/
class duplicate {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        // is need to to arrange all the values of list in lexographical order
        // Collections.sort(res, (n1, n2) -> Integer.compare(n1.data, n2.data));

        dfs(map, root, res);
        return res;
    }

    private String dfs(Map<String, Integer> map, TreeNode root, List<TreeNode> res) {
        if (root == null)
            return "N";

        String s = String.valueOf(root.val) + "," + dfs(map, root.left, res) + "," + dfs(map, root.right, res);
        if (map.containsKey(s) && map.get(s) == 1) {
            res.add(root);
        }
        map.put(s, map.getOrDefault(s, 0) + 1);
        return s;
    }
}
