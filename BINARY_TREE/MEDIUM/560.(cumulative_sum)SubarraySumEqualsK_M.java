package BINARY_TREE.MEDIUM;

import java.util.*;
//https://leetcode.com/problems/subarray-sum-equals-k/

//This is not a problem of binary tree but this method is used to solve Path sum 3 

//very important 
//how cumulative sum works 

class SubarraySumEqualsK_M {
    public int subarraySum(int[] nums, int k) {
        // Cumulative sum
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum - k)) {
                count = count + map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
