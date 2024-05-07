package Medium.Miscellaneous;

import java.util.*;

//https://www.naukri.com/code360/problems/find-minimum-sum-subarray-of-given-size_873368
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
