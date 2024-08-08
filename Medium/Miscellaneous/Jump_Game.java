
//https://leetcode.com/problems/jump-game/
public class Jump_Game {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // Maximum index we can reach
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}
