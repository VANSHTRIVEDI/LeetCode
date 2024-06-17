package Medium.Miscellaneous;

//https://www.geeksforgeeks.org/problems/majority-element-1587115620/1
public class Majority_Element {
    static int majorityElement(int nums[], int size) {

        int candidate = majority(nums, size);

        if (isMajority(candidate, nums, size))
            return candidate;

        return -1;

    }

    public static int majority(int nums[], int size) {
        int majorityElement = nums[0];
        int count = 1;
        for (int i = 1; i < size; i++) {
            if (majorityElement == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    count = 1;
                    majorityElement = nums[i];
                }
            }
        }

        return majorityElement;

    }

    public static Boolean isMajority(int candidate, int nums[], int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (candidate == nums[i]) {
                count++;
            }

        }
        if (count > size / 2)
            return true;

        return false;

    }
}
