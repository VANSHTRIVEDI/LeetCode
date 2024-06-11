package Medium.Miscellaneous;

//https://www.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1
public class Minimum_number_jumps {
    static int minJumps(int[] nums, int n) {

        int current = 0;
        int farthest = 0;
        int jumps = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1)
                return jumps;

            farthest = Math.max(farthest, nums[i] + i);

            if (current == i) {
                if (farthest <= current)
                    return -1;
                else {
                    jumps++;
                    current = farthest;
                }

                if (farthest >= n - 1)
                    return jumps;

            }

        }
        return jumps;
    }
}
