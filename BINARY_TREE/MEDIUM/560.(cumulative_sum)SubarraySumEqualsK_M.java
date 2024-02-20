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

class SubarraySumEqualsK_M2 {
    public static List<List<Integer>> subarraysWithSumK(int[] a, long k) {
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Long, Integer> map = new HashMap<>();
        map.put((long) 0, -1);
        long sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];

            if (map.containsKey(sum - k)) {
                list.add(createList(map.get(sum - k) + 1, i, a));
            }
            map.put((long) sum, i);

        }
        return list;
    }

    public static List<Integer> createList(int start, int end, int arr[]) {
        List<Integer> bb = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            bb.add(arr[i]);
        }
        return bb;

    }
}