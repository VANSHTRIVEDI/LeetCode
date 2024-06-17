package Medium.Miscellaneous;

//https://leetcode.com/problems/sum-of-square-numbers/?envType=daily-question&envId=2024-06-17
public class Sum_Square_Numbers {
    public boolean judgeSquareSum(int c) {
        long low = 0;
        long high = (long) Math.sqrt(c);

        while (low <= high) {
            long ans = (low * low) + (high * high);
            if (ans > c) {
                high--;
            } else if (ans < c) {
                low++;
            } else {
                return true;
            }
        }
        return false;
    }
}
