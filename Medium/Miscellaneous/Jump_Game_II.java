
public class Jump_Game_II {
    public int jump(int[] nums) {
        int farthest = 0;
        int current = 0;
        int move = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);

            if (i == current) {

                // we can do this also
                // if (farthest >= nums.length- 1) {
                // return move+1 ;
                // }
                current = farthest;

                move++;
            }
        }
        return move;
    }

    // this is the second way to do it
    public int jump2(int[] nums) {
        if (nums.length == 1)
            return 0;

        int n = nums.length;
        int l = 0, r = 0, jumps = 0, farthest = 0;

        while (r <= n - 1) {
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
                if (farthest >= n - 1) {
                    return jumps + 1;
                }
            }
            l = r + 1;
            r = farthest;
            jumps++;
        }

        return jumps;
    }
}
