package Medium.Miscellaneous;

//https://leetcode.com/problems/missing-number/
import java.util.*;

public class Missing_Number {
    public int missingNumber(int[] nums) {
        // 3 0 1
        int n = nums.length;
        int Tsum = (n * (n + 1)) / 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        // int actualSum = Arrays.stream(nums).sum();
        // return Tsum - actualSum;
        return Tsum - sum;
    }

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int[] v = new int[n + 1];
        Arrays.fill(v, -1);
        for (int i = 0; i < nums.length; i++) {
            v[nums[i]] = nums[i];
        }
        for (int i = 0; i < v.length; i++) {
            if (v[i] == -1)
                return i;
        }
        return 0;
    }
}
