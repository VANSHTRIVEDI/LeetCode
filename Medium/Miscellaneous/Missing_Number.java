package Medium.Miscellaneous;

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
}
