package Medium.Miscellaneous;

//https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/description/?envType=daily-question&envId=2024-04-29
public class Minimum_Number_Operations_Make_Array_XOR {
    public int minOperations(int[] nums, int k) {
        int finalXor = 0;
        // XOR of all integers in the array.
        for (int n : nums) {
            finalXor = finalXor ^ n;
        }

        int count = 0;
        // Keep iterating until both k and finalXor becomes zero.
        while (k > 0 || finalXor > 0) {
            // k % 2 returns the rightmost bit in k,
            // finalXor % 2 returns the rightmost bit in finalXor.
            // Increment counter, if the bits don't match.
            if ((k % 2) != (finalXor % 2)) {
                count++;
            }

            // Remove the last bit from both integers.
            k /= 2;
            finalXor /= 2;
        }

        return count;
    }
}
