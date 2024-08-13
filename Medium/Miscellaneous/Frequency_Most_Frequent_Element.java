package Medium.Miscellaneous;


//https://leetcode.com/problems/frequency-of-the-most-frequent-element/submissions/
import java.util.*;

public class Frequency_Most_Frequent_Element {

    // using sliding window
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        long sum = 0;
        int max = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            long count = r - l + 1;
            long want = count * nums[r];
            long have = sum;
            long diff = want - have;

            if (diff > k) {
                sum -= nums[l];
                l++;
            } else {
                max = Math.max(max, r - l + 1);
            }

        }
        return max;
    }

}

// using binary search
class Frequency_Most_Frequent_Element2 {
    static int count;

    public int maxFrequency(int[] nums, int k) {
        count = 0;
        Arrays.sort(nums);
        int maxcount = 0;
        int sum[] = new int[nums.length];
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            sum[i] = s;
        }
        // System.out.println(Arrays.toString(sum));
        for (int i = 0; i < nums.length; i++) {
            binarySearch(nums, sum, i, k);

        }
        return count;
    }

    public static void binarySearch(int nums[], int sum[], int k, int limit) {
        int start = 0;
        int end = k;

        while (start <= end) {
            int mid = (start + end) / 2;
            int want = (k - mid + 1) * nums[k];
            int have = 0;
            if (mid == 0) {
                have = sum[k];
            } else {
                have = sum[k] - sum[mid - 1];
            }
            int diff = want - have;
            // if(k==2)System.out.println(want+" "+have+" "+diff);
            if (diff == limit) {
                int c = k - mid + 1;
                count = Math.max(count, c);
                break;
            } else if (diff < limit) {
                int c = k - mid + 1;
                count = Math.max(count, c);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }
}
