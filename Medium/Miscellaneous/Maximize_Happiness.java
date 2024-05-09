package Medium.Miscellaneous;

//https://leetcode.com/problems/maximize-happiness-of-selected-children/?envType=daily-question&envId=2024-05-09
import java.util.Arrays;

public class Maximize_Happiness {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum = 0;
        int p = 0;
        for (int i = happiness.length - 1; i >= happiness.length - k; --i) {
            int kp = Math.max(happiness[i] - p, 0);
            sum = sum + kp;
            p++;
        }
        return sum;

    }
}
