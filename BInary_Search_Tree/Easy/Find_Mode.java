package BInary_Search_Tree.Easy;

//https://leetcode.com/problems/find-mode-in-binary-search-tree/description/

//better method
import java.util.*;;

class Solution {
    static int currnode = 0;
    static int currfreq = 0;
    static int maxfreq = 0;
    static ArrayList<Integer> arr = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        currnode = currfreq = maxfreq = 0;
        arr.clear();
        dfs(root);

        int size = arr.size();

        int auu[] = new int[size];

        for (int i = 0; i < size; i++) {
            auu[i] = arr.get(i);
        }
        return auu;
    }

    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);

        if (root.val == currnode) {
            currfreq++;
        } else {
            currfreq = 1;
        }

        currnode = root.val;
        if (currfreq == maxfreq) {
            arr.add(currnode);
        } else if (currfreq > maxfreq) {
            maxfreq = currfreq;
            arr.clear();
            arr.add(currnode);
        }

        dfs(root.right);

    }
}

// in second we can use hashmap also but above one is better