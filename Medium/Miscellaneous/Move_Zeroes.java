package Medium.Miscellaneous;

//https://leetcode.com/problems/move-zeroes/
public class Move_Zeroes {
    public void moveZeroes(int[] nums) {

        int j = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                int temp = nums[j];
                nums[j] = nums[r];
                nums[r] = temp;
                j++;
            }
            r++;
        }

    }

    public void moveZeroes2(int[] nums) {
        int countZero = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZero++;
            } else {
                nums[j++] = nums[i];
            }
        }
        for (int i = 0; i < countZero; i++) {
            nums[j++] = 0;
        }
    }
}
