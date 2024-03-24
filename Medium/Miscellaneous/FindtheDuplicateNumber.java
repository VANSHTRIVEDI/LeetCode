package Medium.Miscellaneous;

//https://leetcode.com/problems/find-the-duplicate-number/?envType=daily-question&envId=2024-03-24
public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do { // we are sure that at least one duplicate is there
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // find the head of loop
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
