package Medium.Miscellaneous;

//https://leetcode.com/problems/minimum-increment-to-make-array-unique/?envType=daily-question&envId=2024-06-14
import java.util.Arrays;

public class Minimum_Increment_Make_Array_Unique {
    public int minIncrementForUnique(int[] nums) {

        int maxEle = Arrays.stream(nums).max().getAsInt();
        // [7,7,7,7,7,7]
        // Expected 15
        // This case we will handle using an array of this size
        int arr[] = new int[maxEle + nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0)
                continue;
            int d = arr[i] - 1;
            arr[i + 1] = arr[i + 1] + d;
            count = count + d;

        }

        return count;
    }

    // using count sort
    public int minIncrementForUnique2(int[] nums) {
        int maxEle = Arrays.stream(nums).max().getAsInt();

        // Instead of creating array of size maxEle+n
        // we will handle it saperately
        int arr[] = new int[maxEle + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0)
                continue;
            int d = arr[i] - 1;
            arr[i + 1] = arr[i + 1] + d;
            count = count + d;

        }
        // [7,7,7,7,7,7]
        // 15
        // handling last index
        int n = arr[arr.length - 1];
        int index = 1;
        while (n > 1) {
            count = count + index;
            index++;
            n--;
        }

        return count;
    }

    // Using Sorting
    public int minIncrementForUnique3(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                continue;
            } else if (nums[i - 1] == nums[i]) {
                nums[i]++;
                count++;
            } else {
                int diff = (nums[i - 1] - nums[i]) + 1;
                count = count + diff;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return count;

    }
}
