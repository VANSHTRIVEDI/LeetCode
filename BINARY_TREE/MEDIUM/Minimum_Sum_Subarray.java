package BINARY_TREE.MEDIUM;

import java.util.*;

public class Minimum_Sum_Subarray {
    public static int minSubarraySum(ArrayList<Integer> arr, int n, int k) {
        int sum = 0, j = 0;
        while (j < k)
            sum += arr.get(j++);
        int minSum = sum;
        for (int i = 0; i < n - k; i++) {
            sum = sum - arr.get(i) + arr.get(j);
            minSum = Math.min(minSum, sum);
            j++;
        }
        return minSum;
    }
}
